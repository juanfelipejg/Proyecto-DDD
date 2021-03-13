package domain.juego;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.events.JuegoCreado;
import domain.juego.events.JugadorAgregado;
import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.juego.values.Nombre;
import domain.juego.values.RondaId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Juego extends AggregateEvent<JuegoId> {

    protected RondaId rondaId;
    protected Map<JugadorId, Jugador> jugadores;
    protected Boolean juegoIniciado;
    protected Boolean juegoTerminado;

    public Juego(JuegoId entityId, Set<Jugador> jugadores) {
        super(entityId);
        Map<JugadorId, Jugador> newJugadores = new HashMap<>();
        jugadores.forEach(jugador -> newJugadores.put(jugador.identity(), jugador));
        appendChange(new JuegoCreado(newJugadores)).apply();
    }

    public Juego(JuegoId entityId){
        super(entityId);
        subscribe(new JuegoChange(this));
    }

    public static Juego from (JuegoId entityId, List<DomainEvent> events){
        var juego = new Juego(entityId);
        events.forEach(juego::applyEvent);
        return juego;
    }

    public void agregarJugador(JugadorId jugadorId, Nombre nombre){
        appendChange(new JugadorAgregado(jugadorId,nombre)).apply();
    }





}
