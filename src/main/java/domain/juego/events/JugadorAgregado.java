package domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.values.JugadorId;
import domain.juego.values.Nombre;

public class JugadorAgregado extends DomainEvent {

    protected final JugadorId jugadorId;
    protected final Nombre nombre;

    public JugadorAgregado(JugadorId jugadorId, Nombre nombre) {
        super("NoMeMientas.domain.juego");
        this.jugadorId = jugadorId;
        this.nombre = nombre;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
