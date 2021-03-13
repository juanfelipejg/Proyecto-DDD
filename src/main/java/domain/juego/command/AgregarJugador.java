package domain.juego.command;

import co.com.sofka.domain.generic.Command;
import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.juego.values.Nombre;

public class AgregarJugador implements Command {

    private final JuegoId juegoId;
    private final JugadorId jugadorId;
    private final Nombre nombre;

    public AgregarJugador(JuegoId juegoId, JugadorId jugadorId, Nombre nombre) {
        this.juegoId = juegoId;
        this.jugadorId = jugadorId;
        this.nombre = nombre;
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
}
