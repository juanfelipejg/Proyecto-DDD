package usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.Jugador;
import domain.juego.command.IniciarJuego;
import domain.juego.events.JuegoCreado;
import domain.juego.events.JuegoIniciado;
import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.juego.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IniciarJuegoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void iniciarJuego(){
        var juegoId = JuegoId.of("ffff");
        var command = new IniciarJuego(juegoId);

        when(repository.getEventsBy(juegoId.value())).thenReturn(eventStored());

        var iniciarJuegoUseCase = new IniciarJuegoUseCase();
        iniciarJuegoUseCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(juegoId.value())
                .syncExecutor(iniciarJuegoUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (JuegoIniciado)events.get(0);
        Assertions.assertEquals(juegoId.value(), event.aggregateRootId());
    }

    @Test
    void juegoYaIniciado(){

        var juegoId = JuegoId.of("ffff");
        var command = new IniciarJuego(juegoId);
        var events = new ArrayList<>(eventStored());
        events.add(new JuegoIniciado());

        when(repository.getEventsBy(juegoId.value())).thenReturn(events);

        var iniciarJuegoUseCase = new IniciarJuegoUseCase();
        iniciarJuegoUseCase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class, () ->
                UseCaseHandler.getInstance()
                .setIdentifyExecutor(juegoId.value())
                .syncExecutor(iniciarJuegoUseCase, new RequestCommand<>(command))
                .orElseThrow(), "El juego ya esta inicializado"
        );
    }

    private List<DomainEvent> eventStored() {
        return List.of(new JuegoCreado(Map.of(
                JugadorId.of("xxxx"), new Jugador(JugadorId.of("xxxx"),new Nombre("Juan Felipe Jaramillo")),
                JugadorId.of("ffff"), new Jugador(JugadorId.of("ffff"),new Nombre("David Cardona Montoya")),
                JugadorId.of("tttt"), new Jugador(JugadorId.of("tttt"),new Nombre("Jhovan Espinal Zapata"))
        )));
    }

}