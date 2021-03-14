package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.juego.events.JuegoIniciado;

public class CrearRondaUseCase extends UseCase<TriggeredEvent<JuegoIniciado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<JuegoIniciado> juegoIniciadoTriggeredEvent) {

        var event = juegoIniciadoTriggeredEvent.getDomainEvent();


    }
}
