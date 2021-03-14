package domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;

public class JuegoIniciado extends DomainEvent {

    public JuegoIniciado() {
        super("NoMeMientas.juego.iniciado");
    }
}
