package usecase.ronda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.values.Adivinanza;
import domain.juego.values.Apuesta;
import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.ronda.commands.CrearCase;
import domain.ronda.events.CaseCreado;
import domain.ronda.events.DadosLanzados;
import domain.ronda.events.EtapaInicialCreada;
import domain.ronda.events.RondaCreada;
import domain.ronda.values.Cara;
import domain.ronda.values.EtapaId;
import domain.ronda.values.RondaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearCaseUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void validarCase(){

        var etapaId = EtapaId.of(1);
        var jugadorId = JugadorId.of("xxxx");
        var adivinanza = new Adivinanza(3,3);
        var apuesta = new Apuesta(1000);
        var command = new CrearCase(etapaId,jugadorId,adivinanza,apuesta);
        var useCase = new CrearCaseUseCase();
        var rondaId = RondaId.of("hhhh");
        var juegoId = JuegoId.of("ffff");

        when(repository.getEventsBy(rondaId.value())).thenReturn(eventStored(juegoId));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(rondaId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CaseCreado) events.get(0);
        //Assertions.assertEquals(1, event.getEtapaId().value());
        Assertions.assertEquals("xxxx", event.getJugadorId().value());
        Assertions.assertEquals(1000, event.getApuesta().value());
        Assertions.assertEquals(3, event.getAdivinanza().value().numero());
        Assertions.assertEquals(3, event.getAdivinanza().value().repeticiones());

    }

    private List<DomainEvent> eventStored(JuegoId juegoId) {

        List<Cara> caras = new ArrayList<>();

        for(int i=0; i<6; i++){
            int numero = (int) ((Math.random() * 6) + 1);
            caras.add(new Cara(numero));
        }

        return List.of(
                new RondaCreada((Set.of(JugadorId.of("xxxx"), JugadorId.of("ffff"))), juegoId),
                new DadosLanzados(caras),
                new EtapaInicialCreada(EtapaId.of(1), caras));
    }

}