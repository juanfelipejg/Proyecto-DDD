package org.example.NoMeMientas.domain.juego;

import co.com.sofka.domain.generic.EventChange;
import org.example.NoMeMientas.domain.juego.events.JuegoCreado;
import org.example.NoMeMientas.domain.juego.events.JuegoIniciado;
import org.example.NoMeMientas.domain.juego.events.JugadorAdicionado;
import org.example.NoMeMientas.domain.juego.events.JugadorAgregado;

import java.util.HashMap;

public class JuegoChange extends EventChange {

    public JuegoChange(Juego juego){

        apply((JuegoCreado event) -> {
            juego.juegoIniciado = Boolean.FALSE;
            juego.jugadores = new HashMap<>();
        });


        apply((JuegoIniciado event) -> {
            juego.juegoIniciado = Boolean.TRUE;
        });

        apply((JugadorAdicionado event) -> {
            if (juego.juegoIniciado.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("No se puede crear un nuevo jugador si el juego esta en marcha");
            }
            juego.jugadores.put(event.getJugadorId(),
                    new Jugador(
                            event.getJugadorId(),
                            event.getNombre(),
                            event.getCapital()
                    )
            );
        });

        apply((JugadorAgregado event) -> {
            if(juego.jugadores.size() < 25){
                juego.jugadores.put(event.getJugadorId(), new Jugador(event.getJugadorId(), event.getNombre(), event.getCapital()));
            }else {
                throw new IllegalArgumentException("No se pueden ingresar mas jugadores");
            }
        });

    }
}
