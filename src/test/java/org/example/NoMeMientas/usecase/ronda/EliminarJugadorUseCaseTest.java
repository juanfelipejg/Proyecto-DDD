package org.example.NoMeMientas.usecase.ronda;

import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.ronda.commands.EliminarJugador;
import org.example.NoMeMientas.domain.ronda.values.RondaId;
import org.junit.jupiter.api.Test;

class EliminarJugadorUseCaseTest {

    @Test
    void validarEliminacion(){

        var juegoId = JuegoId.of("hhhh");
        var rondaId = RondaId.of("xxxx");
        var jugadorId = JugadorId.of("erec");
        var command = new EliminarJugador(juegoId,rondaId,jugadorId);


    }
}