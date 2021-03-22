package org.example.NoMeMientas.usecase.ronda;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.NoMeMientas.domain.juego.events.JuegoIniciado;
import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.domain.ronda.values.RondaId;
import org.example.NoMeMientas.domain.ronda.Ronda;

public class CrearRondaUseCase extends UseCase<TriggeredEvent<JuegoIniciado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<JuegoIniciado> juegoIniciadoTriggeredEvent) {

        var event = juegoIniciadoTriggeredEvent.getDomainEvent();
        var rondaId = new RondaId();
        var juegoId = JuegoId.of(event.aggregateRootId());
        var ronda = new Ronda(rondaId, juegoId, event.getJugadoresIds());

        if (event.getJugadoresIds().size() < 2) {
            throw new BusinessException(rondaId.value(), "No se puede crear la ronda por falta de jugadores");
        }

        emit().onResponse(new ResponseEvents(ronda.getUncommittedChanges()));

    }
}
