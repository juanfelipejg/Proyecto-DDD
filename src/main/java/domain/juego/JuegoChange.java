package domain.juego;

import co.com.sofka.domain.generic.EventChange;
import domain.juego.events.JuegoCreado;

public class JuegoChange extends EventChange {

    public JuegoChange(Juego juego){

        apply((JuegoCreado event) -> {
            juego.jugadores = event.getJugadores();
            juego.juegoIniciado = Boolean.FALSE;
            juego.juegoTerminado = Boolean.FALSE;
        });

    }
}
