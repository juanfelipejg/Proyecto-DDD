package org.example.NoMeMientas.usecase.juego;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.NoMeMientas.domain.juego.command.IniciarJuego;
import org.example.NoMeMientas.domain.juego.events.JuegoCreado;
import org.example.NoMeMientas.domain.juego.events.JuegoIniciado;
import org.example.NoMeMientas.domain.juego.events.JugadorAdicionado;
import org.example.NoMeMientas.domain.juego.values.Capital;
import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.juego.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IniciarJuegoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void iniciarJuego(){

        var juegoId = JuegoId.of("xxxx");
        var command = new IniciarJuego(juegoId);
        var useCase = new IniciarJuegoUseCase();

        when(repository.getEventsBy(juegoId.value())).thenReturn(eventStored(juegoId));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(juegoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (JuegoIniciado)events.get(0);
        Assertions.assertEquals(3, event.getJugadoresIds().size());
    }


    private List<DomainEvent> eventStored(JuegoId id) {
        return List.of(
                new JuegoCreado(id),
                new JugadorAdicionado(JugadorId.of("ffff"), new Nombre("Raul Alzate"), new Capital(500)),
                new JugadorAdicionado(JugadorId.of("gggg"), new Nombre("Raul Alzate"), new Capital(500)),
                new JugadorAdicionado(JugadorId.of("hhhh"), new Nombre("Raul Alzate"), new Capital(500))
        );
    }

}