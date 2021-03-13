package domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.Jugador;
import domain.juego.values.JugadorId;

import java.util.Map;

public class JuegoCreado extends DomainEvent {

    private final Map<JugadorId, Jugador> jugadores;

    public JuegoCreado(Map<JugadorId, Jugador> jugadores) {
        super("NoMeMientas.domain.juego");
        this.jugadores = jugadores;
    }

    public Map<JugadorId, Jugador> getJugadores() {
        return jugadores;
    }
}
