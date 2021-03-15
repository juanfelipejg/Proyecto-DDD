package usecase.ronda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.ronda.events.DadosLanzados;
import domain.ronda.events.EtapaInicialCreada;
import domain.ronda.events.RondaCreada;
import domain.ronda.values.Cara;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearEtapaInicialUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void validarEtapaInicial(){

        List<Cara> caras = new ArrayList<>();

        for(int i=0; i<6; i++){
            int numero = (int) ((Math.random() * 6) + 1);
            caras.add(new Cara(numero));
        }

        var event = new DadosLanzados(caras);
        event.setAggregateRootId("hhhh");
        var juegoId = JuegoId.of("xxxx");

        when(repository.getEventsBy(event.aggregateRootId())).thenReturn(eventStored(juegoId));
        var useCase = new CrearEtapaInicialUseCase();
        useCase.addRepository(repository);


        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(event.aggregateRootId())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var etapaInicialCreada = (EtapaInicialCreada) events.get(0);
        Assertions.assertNotNull(etapaInicialCreada.getEtapaId());
        Assertions.assertEquals(3,etapaInicialCreada.getCarasVisibles().size());

    }

    private List<DomainEvent> eventStored(JuegoId juegoId) {

        List<Cara> caras = new ArrayList<>();

        for(int i=0; i<6; i++){
            int numero = (int) ((Math.random() * 6) + 1);
            caras.add(new Cara(numero));
        }

        return List.of(
                new RondaCreada((Set.of(JugadorId.of("xxxx"), JugadorId.of("ffff"))), juegoId),
                new DadosLanzados(caras));
    }

}