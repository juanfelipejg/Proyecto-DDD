package domain.juego;

import co.com.sofka.domain.generic.EventChange;
import domain.juego.events.JuegoCreado;
import domain.juego.events.JuegoIniciado;
import domain.juego.events.JugadorAgregado;

public class JuegoChange extends EventChange {

    public JuegoChange(Juego juego){

        apply((JuegoCreado event) -> {
            juego.jugadores = event.getJugadores();
            juego.juegoIniciado = Boolean.FALSE;
            juego.juegoTerminado = Boolean.FALSE;
        });

        apply((JugadorAgregado event) -> {
            if(juego.jugadores.size() < 25){
                juego.jugadores.put(event.getJugadorId(), new Jugador(event.getJugadorId(), event.getNombre()));
            }else {
                throw new IllegalArgumentException("No se pueden ingresar mas jugadores");
            }
        });

        apply((JuegoIniciado) -> {
            if(Boolean.TRUE.equals(juego.juegoIniciado)){
                throw new IllegalArgumentException("El juego ya esta iniciado");
            }
            juego.juegoIniciado = Boolean.TRUE;
        });

    }
}
