package domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.juego.values.JuegoId;

public class JuegoCreado extends DomainEvent {

    private final JuegoId juegoId;

    public JuegoCreado(JuegoId juegoId) {
        super("NoMeMientas.domain.juegoCreado");
        this.juegoId = juegoId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}
