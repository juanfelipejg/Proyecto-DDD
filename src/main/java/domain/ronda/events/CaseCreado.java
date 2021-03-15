package domain.ronda.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.values.JugadorId;
import domain.ronda.values.Adivinanza;
import domain.ronda.values.Apuesta;
import domain.ronda.values.EtapaId;

public class CaseCreado extends DomainEvent {
    private final EtapaId etapaId;
    private final JugadorId jugadorId;
    private final Adivinanza adivinanza;
    private final Apuesta apuesta;


    public CaseCreado(EtapaId etapaId,JugadorId jugadorId, Adivinanza adivinanza, Apuesta apuesta) {
        super("NoMeMientas.domain.casoCreado");
        this.etapaId = etapaId;
        this.jugadorId = jugadorId;
        this.adivinanza = adivinanza;
        this.apuesta = apuesta;
    }

    public EtapaId getEtapaId() {
        return etapaId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Adivinanza getAdivinanza() {
        return adivinanza;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }
}
