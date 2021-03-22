package org.example.NoMeMientas.domain.ronda.commands;

import co.com.sofka.domain.generic.Command;
import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.ronda.values.RondaId;

public class EliminarJugador implements Command {

    private final JuegoId juegoId;
    private final RondaId rondaId;
    private final JugadorId jugadorId;

    public EliminarJugador(JuegoId juegoId, RondaId rondaId, JugadorId jugadorId) {
        this.juegoId = juegoId;
        this.rondaId = rondaId;
        this.jugadorId = jugadorId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }

    public RondaId getRondaId() {
        return rondaId;
    }
    public JugadorId getJugadorId() {
        return jugadorId;
    }

}
