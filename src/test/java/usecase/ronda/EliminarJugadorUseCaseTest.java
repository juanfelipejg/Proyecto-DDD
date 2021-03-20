package usecase.ronda;

import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.ronda.commands.EliminarJugador;
import domain.ronda.values.RondaId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EliminarJugadorUseCaseTest {

    @Test
    void validarEliminacion(){

        var juegoId = JuegoId.of("hhhh");
        var rondaId = RondaId.of("xxxx");
        var jugadorId = JugadorId.of("erec");
        var command = new EliminarJugador(juegoId,rondaId,jugadorId);


    }
}