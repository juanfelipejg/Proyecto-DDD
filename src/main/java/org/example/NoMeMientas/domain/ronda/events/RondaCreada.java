package org.example.NoMeMientas.domain.ronda.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.domain.juego.values.JugadorId;

import java.util.Set;

public class RondaCreada extends DomainEvent {

    private final Set<JugadorId> jugadorIds;
    private final JuegoId juegoId;

    public RondaCreada(Set<JugadorId> jugadorIds, JuegoId juegoId) {
        super("NoMeMientas.org.example.NoMeMientas.domain.rondaCreada");
        this.jugadorIds = jugadorIds;
        this.juegoId = juegoId;
    }

    public Set<JugadorId> getJugadorIds() {
        return jugadorIds;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}
