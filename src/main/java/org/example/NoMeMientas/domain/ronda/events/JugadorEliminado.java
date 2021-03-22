package org.example.NoMeMientas.domain.ronda.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.NoMeMientas.domain.juego.values.JugadorId;

public class JugadorEliminado extends DomainEvent {

    protected final JugadorId jugadorId;

    public JugadorEliminado(JugadorId jugadorId) {
        super("NoMeMientas.org.example.NoMeMientas.domain.jugadorEliminado");
        this.jugadorId = jugadorId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }
}
