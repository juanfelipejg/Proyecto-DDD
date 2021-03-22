package org.example.NoMeMientas.domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.NoMeMientas.domain.juego.values.Capital;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.juego.values.Nombre;

public class JugadorAgregado extends DomainEvent {

    protected final JugadorId jugadorId;
    protected final Nombre nombre;
    protected final Capital capital;

    public JugadorAgregado(JugadorId jugadorId, Nombre nombre, Capital capital) {
        super("NoMeMientas.org.example.NoMeMientas.domain.jugadorAgregado");
        this.jugadorId = jugadorId;
        this.nombre = nombre;
        this.capital = capital;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Capital getCapital() {
        return capital;
    }
}
