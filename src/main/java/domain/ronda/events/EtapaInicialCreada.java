package domain.ronda.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.ronda.Etapa;
import domain.ronda.values.Cara;
import domain.ronda.values.EtapaId;

import java.util.List;

public class EtapaInicialCreada extends DomainEvent {

    private final EtapaId etapaId;
    private final List<Cara> carasVisibles;

    public EtapaInicialCreada(EtapaId etapaId, List<Cara> carasVisibles) {
        super("nomemientan.ronda.etapacreada");
        this.etapaId = etapaId;
        this.carasVisibles = carasVisibles;
    }
    public List<Cara> getCarasVisibles() {
        return carasVisibles;
    }

    public EtapaId getEtapaId() {
        return etapaId;
    }
}
