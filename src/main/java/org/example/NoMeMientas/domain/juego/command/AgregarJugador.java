package org.example.NoMeMientas.domain.juego.command;

import co.com.sofka.domain.generic.Command;
import org.example.NoMeMientas.domain.juego.values.Capital;
import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.juego.values.Nombre;

public class AgregarJugador implements Command {

    private final JuegoId juegoId;
    private final JugadorId jugadorId;
    private final Nombre nombre;
    private final Capital capital;

    public AgregarJugador(JuegoId juegoId, JugadorId jugadorId, Nombre nombre, Capital capital) {
        this.juegoId = juegoId;
        this.jugadorId = jugadorId;
        this.nombre = nombre;
        this.capital = capital;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Capital getCapital() {
        return capital;
    }
}
