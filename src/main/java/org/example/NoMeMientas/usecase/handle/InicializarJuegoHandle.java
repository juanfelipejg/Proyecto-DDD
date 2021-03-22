package org.example.NoMeMientas.usecase.handle;

import co.com.sofka.business.annotation.CommandHandles;
import co.com.sofka.business.annotation.CommandType;
import co.com.sofka.business.asyn.UseCaseExecutor;
import co.com.sofka.business.support.RequestCommand;
import org.example.NoMeMientas.domain.juego.command.IniciarJuego;
import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.usecase.juego.IniciarJuegoUseCase;

import java.util.Map;

@CommandHandles
@CommandType(name = "nomemientas.juego.inicializar", aggregate = "juego")
public class InicializarJuegoHandle extends UseCaseExecutor {

    private RequestCommand<IniciarJuego> request;
    @Override
    public void run() {
        runUseCase(new IniciarJuegoUseCase(), request);

    }

    @Override
    public void accept(Map<String, String> args) {

        var juegoId = args.get("aggregateId");

        request = new RequestCommand<>(new IniciarJuego(JuegoId.of(juegoId)));

    }
}
