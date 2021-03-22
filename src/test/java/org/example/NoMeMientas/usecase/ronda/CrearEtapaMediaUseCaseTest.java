package org.example.NoMeMientas.usecase.ronda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.ronda.events.DadosLanzados;
import org.example.NoMeMientas.domain.ronda.events.EtapaInicialCreada;
import org.example.NoMeMientas.domain.ronda.events.EtapaMediaCreada;
import org.example.NoMeMientas.domain.ronda.events.RondaCreada;
import org.example.NoMeMientas.domain.ronda.values.Cara;
import org.example.NoMeMientas.domain.ronda.values.EtapaId;
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
class CrearEtapaMediaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void validarEtapaMedia(){

        var etapaId = EtapaId.of(1);
        List<Cara> caras = new ArrayList<>();

        for(int i=0; i<6; i++){
            int numero = (int) ((Math.random() * 6) + 1);
            caras.add(new Cara(numero));
        }

        var event = new EtapaInicialCreada(etapaId,caras);
        event.setAggregateRootId("hhhh");
        var juegoId = JuegoId.of("xxxx");

        when(repository.getEventsBy(event.aggregateRootId())).thenReturn(eventStored(juegoId));
        var useCase = new CrearEtapaMediaUseCase();
        useCase.addRepository(repository);


        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(event.aggregateRootId())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var etapaMediaCreada = (EtapaMediaCreada) events.get(0);
        Assertions.assertNotNull(etapaMediaCreada.getEtapaId());
        Assertions.assertEquals(5,etapaMediaCreada.getCarasVisibles().size());

    }

    private List<DomainEvent> eventStored(JuegoId juegoId) {

        var etapaId = EtapaId.of(1);
        List<Cara> caras = new ArrayList<>();

        for(int i=0; i<6; i++){
            int numero = (int) ((Math.random() * 6) + 1);
            caras.add(new Cara(numero));
        }

        return List.of(
                new RondaCreada((Set.of(JugadorId.of("xxxx"), JugadorId.of("ffff"))), juegoId),
                new DadosLanzados(caras),
                new EtapaInicialCreada(etapaId,caras));
    }

}