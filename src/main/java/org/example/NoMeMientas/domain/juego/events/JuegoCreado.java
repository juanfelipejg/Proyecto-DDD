package org.example.NoMeMientas.domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.NoMeMientas.domain.juego.values.JuegoId;

public class JuegoCreado extends DomainEvent {

    private final JuegoId juegoId;

    public JuegoCreado(JuegoId juegoId) {
        super("NoMeMientas.org.example.NoMeMientas.domain.juegoCreado");
        this.juegoId = juegoId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}
