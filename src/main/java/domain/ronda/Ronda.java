package domain.ronda;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.juego.values.RondaId;
import domain.ronda.events.RondaCreada;
import domain.ronda.values.DadoId;
import domain.ronda.values.EtapaId;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ronda extends AggregateEvent<RondaId> {

    protected JuegoId juegoId;
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
}
