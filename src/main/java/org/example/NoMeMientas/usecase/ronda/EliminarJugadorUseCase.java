package org.example.NoMeMientas.usecase.ronda;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.NoMeMientas.domain.ronda.Ronda;
import org.example.NoMeMientas.domain.ronda.commands.EliminarJugador;

public class EliminarJugadorUseCase extends UseCase<RequestCommand<EliminarJugador>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EliminarJugador> eliminarJugadorRequestCommand) {
        var command = eliminarJugadorRequestCommand.getCommand();
        var ronda = Ronda.from(command.getRondaId(), retrieveEvents());
        try{
            ronda.eliminarJugador(command.getJugadorId());
            emit().onResponse(new ResponseEvents(ronda.getUncommittedChanges()));
        } catch (RuntimeException e){
            emit().onError(new BusinessException(ronda.identity().value(), e.getMessage()));
        }
    }
}
