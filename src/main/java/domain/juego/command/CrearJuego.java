package domain.juego.command;

import co.com.sofka.domain.generic.Command;
import domain.juego.Jugador;

import java.util.Set;

public class CrearJuego implements Command {

    private final Set<Jugador> jugadores;

    public CrearJuego(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }
}
