package usecase.handle;

import co.com.sofka.business.annotation.CommandHandles;
import co.com.sofka.business.annotation.CommandType;
import co.com.sofka.business.asyn.UseCaseExecutor;
import co.com.sofka.business.support.RequestCommand;
import domain.juego.command.CrearJuego;
import domain.juego.values.Capital;
import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.juego.values.Nombre;
import usecase.juego.CrearJuegoUseCase;

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
