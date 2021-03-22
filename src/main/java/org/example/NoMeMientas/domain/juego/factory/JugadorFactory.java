package org.example.NoMeMientas.domain.juego.factory;

import org.example.NoMeMientas.domain.juego.Jugador;
import org.example.NoMeMientas.domain.juego.values.Capital;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.juego.values.Nombre;

import java.util.HashSet;
import java.util.Set;

public class JugadorFactory {

    private final Set<Jugador> jugadores;

    private JugadorFactory() {
        jugadores = new HashSet<>();
    }

    public static JugadorFactory builder() {
        return new JugadorFactory();
    }

    public JugadorFactory nuevoJugador(JugadorId jugadorId, Nombre nombre, Capital capital) {
        jugadores.add(new Jugador(jugadorId, nombre, capital));
        return this;
    }

    public Set<Jugador> jugadores() {
        return jugadores;
    }
}
