package org.example.NoMeMientas.domain.ronda;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.NoMeMientas.domain.juego.values.Adivinanza;
import org.example.NoMeMientas.domain.juego.values.Apuesta;
import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.ronda.events.*;
import org.example.NoMeMientas.domain.ronda.values.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ronda extends AggregateEvent<RondaId> {

    protected JuegoId juegoId;
    protected List<Cara> caras;
    protected Map<DadoId, Dado> dados;
    protected Map<EtapaId, Etapa> etapas;
    protected Map<JuegoId, Punto> puntaje;
    protected Set<JugadorId> jugadorIds;

    public Ronda(RondaId entityId, JuegoId juegoId, Set<JugadorId> jugadorIds) {
        super(entityId);
        appendChange(new RondaCreada(jugadorIds, juegoId)).apply();
    }

    private Ronda(RondaId entityId) {
        super(entityId);
        subscribe(new RondaChange(this));
    }

    public static Ronda from(RondaId entityId, List<DomainEvent> events) {
        var ronda = new Ronda(entityId);
        events.forEach(ronda::applyEvent);
        return ronda;
    }

    public void lanzarDados(List<Cara> caras) {
        appendChange(new DadosLanzados(caras)).apply();
    }

    public void insertarEtapaInicial(EtapaId etapaId, List<Cara> caras) {
        appendChange(new EtapaInicialCreada(etapaId,caras)).apply();
    }

    public void recibirCases(EtapaId etapaId, JugadorId jugadorId, Adivinanza adivinanza, Apuesta apuesta) {
        appendChange(new CaseCreado(etapaId, jugadorId,adivinanza,apuesta)).apply();
    }

    public void insertarEtapaMedia(EtapaId etapaId, List<Cara> caras) {
        appendChange(new EtapaMediaCreada(etapaId,caras)).apply();
    }

    public void eliminarJugador(JugadorId jugadorId) {
        appendChange(new JugadorEliminado(jugadorId)).apply();
    }
}
