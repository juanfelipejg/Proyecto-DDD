package org.example.NoMeMientas.usecase.handle;

import co.com.sofka.business.annotation.CommandHandles;
import co.com.sofka.business.annotation.CommandType;
import co.com.sofka.business.asyn.UseCaseExecutor;
import co.com.sofka.business.support.RequestCommand;
import org.example.NoMeMientas.domain.juego.command.CrearJuego;
import org.example.NoMeMientas.domain.juego.values.Capital;
import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.juego.values.Nombre;
import org.example.NoMeMientas.usecase.juego.CrearJuegoUseCase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@CommandHandles
@CommandType(name = "NoMeMientas.juego.crear", aggregate = "juego")
public class CrearJuegoHandle extends UseCaseExecutor {

    private RequestCommand<CrearJuego> request;

    // Ejecutar el caso de uso con su respectivo comando
    @Override
    public void run() {runUseCase(new CrearJuegoUseCase(),request);}

    //Creación de un comando a partir de unos argumentos.
    @Override
    public void accept(Map<String, String> args) {

    Map<JugadorId, Nombre> nombresMap = new HashMap<>();
    Map<JugadorId, Capital> capitalesMap = new HashMap<>();

    var ids = Objects.requireNonNull(args.get("jugadoresIds")).split(",");
    var nombres = Objects.requireNonNull(args.get("nombres")).split(",");
    var capitales = Objects.requireNonNull(args.get("capitales")).split(",");

    for(int i = 0; i< ids.length; i++){
        nombresMap.put(JugadorId.of(ids[i]), new Nombre(nombres[i]));
        capitalesMap.put(JugadorId.of(ids[i]), new Capital(Integer.parseInt(capitales[i])));
    }

    request = new RequestCommand<>(new CrearJuego(JuegoId.of(aggregateId()), capitalesMap, nombresMap));

    }
}
