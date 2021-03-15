package domain.ronda.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.ronda.values.Cara;

import java.util.List;

public class EtapaInicialIniciada extends DomainEvent {

    private final List<Cara> carasVisibles;

    public EtapaInicialIniciada(List<Cara> carasVisibles) {
        super("nomemientan.ronda.etapacreada");
        this.carasVisibles = carasVisibles;
    }

    public List<Cara> getCarasVisibles() {
        return carasVisibles;
    }
}
