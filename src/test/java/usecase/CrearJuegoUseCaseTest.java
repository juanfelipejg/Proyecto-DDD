package usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.juego.command.CrearJuego;
import domain.juego.events.JuegoCreado;
import domain.juego.events.JugadorAdicionado;
import domain.juego.values.Capital;
import domain.juego.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.juego.values.JugadorId;

import java.util.Map;
import java.util.Objects;

class CrearJuegoUseCaseTest {

    @Test
    void crearUnJuego(){
        var nombres = Map.of(
                JugadorId.of("xxxxx"), new Nombre("Juan Felipe Jaramillo"),
                JugadorId.of("ffff"), new Nombre("Daniel Burgos Ramirez")
        );
        var capitales = Map.of(
                JugadorId.of("xxxxx"), new Capital(500),
                JugadorId.of("ffff"), new Capital(500)
        );
        var command = new CrearJuego(capitales, nombres);
        var useCase = new CrearJuegoUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var juegoCreado = (JuegoCreado)events.get(0);
        var jugadorAdicionadoParaFelipe = (JugadorAdicionado)events.get(2);
        var jugadorAdicionadoParaDaniel = (JugadorAdicionado)events.get(1);

        Assertions.assertTrue(Objects.nonNull(juegoCreado.getJuegoId().value()));

        Assertions.assertEquals("Juan Felipe Jaramillo", jugadorAdicionadoParaFelipe.getNombre().value());
        Assertions.assertEquals(500, jugadorAdicionadoParaFelipe.getCapital().value());
        Assertions.assertEquals("xxxxx", jugadorAdicionadoParaFelipe.getJugadorId().value());

        Assertions.assertEquals("Daniel Burgos Ramirez", jugadorAdicionadoParaDaniel.getNombre().value());
        Assertions.assertEquals(500, jugadorAdicionadoParaDaniel.getCapital().value());
        Assertions.assertEquals("ffff", jugadorAdicionadoParaDaniel.getJugadorId().value());

    }


    @Test
    void errorAlCrearJuego(){
        var nombres = Map.of(
                JugadorId.of("xxxxx"), new Nombre("Juan Felipe Jaramillo")
        );
        var capiltales = Map.of(
                JugadorId.of("xxxxx"), new Capital(500)
        );
        var command = new CrearJuego(capiltales, nombres);
        var useCase = new CrearJuegoUseCase();


        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        }, "No se puede crear el juego por que no tiene la cantidad necesaria de jugadores");

    }


}