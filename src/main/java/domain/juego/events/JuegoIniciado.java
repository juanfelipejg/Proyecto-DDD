package domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.values.JugadorId;

import java.util.Set;

public class JuegoIniciado extends DomainEvent {

    private final Set<JugadorId> jugadoresIds;

    public JuegoIniciado(Set<JugadorId> jugadoresIds) {
        super("NoMeMientas.juego.iniciado");
        this.jugadoresIds = jugadoresIds;
    }
}
