package usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.juego.Juego;
import domain.juego.command.IniciarJuego;

public class IniciarJuegoUseCase extends UseCase<RequestCommand<IniciarJuego>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<IniciarJuego> iniciarJuegoRequestCommand) {

        var command = iniciarJuegoRequestCommand.getCommand();
        var juego = Juego.from(command.getJuegoId(), retrieveEvents());

        try{
            juego.iniciarJuego();
            emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));
        } catch (RuntimeException e){
            emit().onError(new BusinessException(juego.identity().value(), e.getMessage()));
        }
    }
}
