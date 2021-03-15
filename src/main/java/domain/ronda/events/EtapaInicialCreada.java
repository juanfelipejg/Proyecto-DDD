package domain.ronda.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.ronda.values.Cara;
import domain.ronda.values.EtapaId;

import java.util.ArrayList;
import java.util.List;

public class EtapaInicialCreada extends DomainEvent {

    private final EtapaId etapaId;
    private final List<Cara> carasVisibles;

    public EtapaInicialCreada(EtapaId etapaId, List<Cara> caras) {
        super("nomemientan.ronda.etapacreada");
        this.etapaId = etapaId;
        this.carasVisibles = caras;
    }
    public List<Cara> getCarasVisibles() {

        List<Cara> caras = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            caras.add(this.carasVisibles.get(i));
        }


        return caras;
    }

    public EtapaId getEtapaId() {
        return etapaId;
    }
}
