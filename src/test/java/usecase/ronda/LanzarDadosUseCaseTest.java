package usecase.ronda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.ronda.events.DadosLanzados;
import domain.ronda.events.RondaCreada;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LanzarDadosUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void validarLanzamiento(){

        var juegoId = JuegoId.of("xxxx");

        var event = new RondaCreada((Set.of(JugadorId.of("xxxx"), JugadorId.of("ffff"))), juegoId);
        event.setAggregateRootId("hhhh");
        var useCase = new LanzarDadosUseCase();

        when(repository.getEventsBy(event.aggregateRootId())).thenReturn(eventStored(juegoId));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(event.aggregateRootId())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var dadosLanzados = (DadosLanzados) events.get(0);
        Assertions.assertNotNull(dadosLanzados.getCaras());

    }

    private List<DomainEvent> eventStored(JuegoId juegoId) {
        return List.of(new RondaCreada((Set.of(JugadorId.of("xxxx"), JugadorId.of("ffff"))), juegoId));
    }

}