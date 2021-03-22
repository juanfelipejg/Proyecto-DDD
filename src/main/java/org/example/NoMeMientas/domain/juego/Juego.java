package org.example.NoMeMientas.domain.juego;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.NoMeMientas.domain.juego.events.JuegoCreado;
import org.example.NoMeMientas.domain.juego.events.JuegoIniciado;
import org.example.NoMeMientas.domain.juego.events.JugadorAdicionado;
import org.example.NoMeMientas.domain.juego.events.JugadorAgregado;
import org.example.NoMeMientas.domain.juego.factory.JugadorFactory;
import org.example.NoMeMientas.domain.juego.values.*;
import org.example.NoMeMientas.domain.ronda.values.RondaId;


import java.util.List;
import java.util.Map;


public class Juego extends AggregateEvent<JuegoId> {

    protected RondaId rondaId;
    protected Map<JugadorId, Jugador> jugadores;
    protected Boolean juegoIniciado;
    protected Boolean juegoTerminado;

    public Juego(JuegoId entityId, JugadorFactory jugadorFactory) {
        super(entityId);
        appendChange(new JuegoCreado(entityId)).apply();
        jugadorFactory.jugadores().forEach(jugador -> adicionarJugador(jugador.identity(), jugador.nombre(), jugador.capital()));
    }

    public Juego(JuegoId entityId){
        super(entityId);
        subscribe(new JuegoChange(this));
    }

    //Reconstrucción del agregado y posteriormente aplico los eventos
    public static Juego from (JuegoId entityId, List<DomainEvent> events){
        var juego = new Juego(entityId);
        events.forEach(juego::applyEvent);
        return juego;
    }

    public void adicionarJugador(JugadorId jugadorId, Nombre nombre, Capital capital) {
        appendChange(new JugadorAdicionado(jugadorId, nombre, capital)).apply();
    }

    public void agregarJugador(JugadorId jugadorId, Nombre nombre, Capital capital){
        appendChange(new JugadorAgregado(jugadorId,nombre, capital)).apply();
    }

    public void iniciarJuego() {
        var jugadoresIds = jugadores.keySet();
        appendChange(new JuegoIniciado(jugadoresIds)).apply();
    }
}
