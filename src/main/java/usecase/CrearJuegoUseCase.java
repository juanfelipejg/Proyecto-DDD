package usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.juego.command.CrearJuego;
import domain.juego.Juego;
import domain.juego.values.JuegoId;

public class CrearJuegoUseCase extends UseCase<RequestCommand<CrearJuego>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearJuego> crearJuegoRequestCommand) {

        var command = crearJuegoRequestCommand.getCommand();

        var juegoId = new JuegoId();

        if(command.getJugadores().size() < 3){
            throw new BusinessException(juegoId.value(),"Debe jugar minimo 3 jugadores");
        }

        var juego = new Juego(juegoId, command.getJugadores());
        //Emision de lista de eventos del agregagos
        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));
    }
}
