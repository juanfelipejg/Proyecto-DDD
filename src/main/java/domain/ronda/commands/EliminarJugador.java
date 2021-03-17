package domain.ronda.commands;

import co.com.sofka.domain.generic.Command;
import domain.juego.values.Capital;
import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.juego.values.Nombre;
import domain.ronda.values.RondaId;

public class EliminarJugador implements Command {

    private final JuegoId juegoId;
    private final RondaId rondaId;
    private final JugadorId jugadorId;
    private final Nombre nombre;
    private final Capital capital;

    public EliminarJugador(JuegoId juegoId, RondaId rondaId, JugadorId jugadorId, Nombre nombre, Capital capital) {
        this.juegoId = juegoId;
        this.rondaId = rondaId;
        this.jugadorId = jugadorId;
        this.nombre = nombre;
        this.capital = capital;
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

    public Nombre getNombre() {
        return nombre;
    }

    public Capital getCapital() {
        return capital;
    }

}
