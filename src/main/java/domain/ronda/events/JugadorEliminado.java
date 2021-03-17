package domain.ronda.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.values.JugadorId;

public class JugadorEliminado extends DomainEvent {

    protected final JugadorId jugadorId;

    public JugadorEliminado(JugadorId jugadorId) {
        super("NoMeMientas.domain.jugadorEliminado");
        this.jugadorId = jugadorId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }
}
