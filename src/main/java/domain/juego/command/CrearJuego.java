package domain.juego.command;

import co.com.sofka.domain.generic.Command;
import domain.juego.Jugador;
import domain.juego.values.JuegoId;

import java.util.Set;

public class CrearJuego implements Command {

    //Comando inmutable por tanto sus atributos son final
    private final Set<Jugador> jugadores;


    public CrearJuego(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }
}
