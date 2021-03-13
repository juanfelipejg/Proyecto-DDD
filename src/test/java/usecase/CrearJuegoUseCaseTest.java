package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.juego.Jugador;
import domain.juego.command.CrearJuego;
import domain.juego.events.JuegoCreado;
import domain.juego.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.juego.values.JugadorId;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CrearJuegoUseCaseTest {

    @Test
    void crearJuego(){
        var command = new CrearJuego(Set.of(
                new Jugador(JugadorId.of("xxxx"), new Nombre("Juan Felipe Jaramillo")),
                new Jugador(JugadorId.of("ffff"), new Nombre("David Cardona Montoya")),
                new Jugador(JugadorId.of("tttt"), new Nombre("Jhovan Espinal Zapata"))
        ));
        var crearJuegoUseCase = new CrearJuegoUseCase();
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(crearJuegoUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var juegoCreado = (JuegoCreado)events.get(0);

        Assertions.assertEquals(3, juegoCreado.getJugadores().size());
        Assertions.assertEquals("Juan Felipe Jaramillo", juegoCreado.getJugadores().get(JugadorId.of("xxxx")).getNombre());
        Assertions.assertEquals("David Cardona Montoya", juegoCreado.getJugadores().get(JugadorId.of("ffff")).getNombre());
        Assertions.assertEquals("Jhovan Espinal Zapata", juegoCreado.getJugadores().get(JugadorId.of("tttt")).getNombre());
    }


}