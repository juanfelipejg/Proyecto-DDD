package domain.ronda.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.values.JugadorId;
import domain.ronda.values.Adivinanza;
import domain.ronda.values.Apuesta;

public class CaseCreado extends DomainEvent {

    private final JugadorId jugadorId;
    private final Adivinanza adivinanza;
    private final Apuesta apuesta;


    public CaseCreado(JugadorId jugadorId, Adivinanza adivinanza,Apuesta apuesta) {
        super("NoMeMientas.domain.dadosLanzados");
        this.jugadorId = jugadorId;
        this.adivinanza = adivinanza;
        this.apuesta = apuesta;
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
