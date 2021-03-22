package org.example.NoMeMientas.usecase.ronda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.NoMeMientas.domain.juego.events.JuegoIniciado;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.ronda.events.RondaCreada;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class CrearRondaUseCaseTest {

    @Test
    void crearRonda(){
        var event = new JuegoIniciado(Set.of(JugadorId.of("xxxx"), JugadorId.of("ffff")));
        event.setAggregateRootId("hhhh");
        var useCase = new CrearRondaUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var rondaCreada = (RondaCreada) events.get(0);
        Assertions.assertEquals("hhhh", rondaCreada.getJuegoId().value());
        Assertions.assertEquals(2, rondaCreada.getJugadorIds().size());
    }

}