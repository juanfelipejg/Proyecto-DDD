package org.example.NoMeMientas.usecase.juego;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.NoMeMientas.domain.juego.Juego;
import org.example.NoMeMientas.domain.juego.command.AgregarJugador;

public class AgregarJugadorUseCase extends UseCase<RequestCommand<AgregarJugador>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarJugador> agregarJugadorRequestCommand) {

        var command = agregarJugadorRequestCommand.getCommand();

        var juego = Juego.from(command.getJuegoId(), retrieveEvents());
        juego.agregarJugador(command.getJugadorId(), command.getNombre(), command.getCapital());
        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));
    }
}
