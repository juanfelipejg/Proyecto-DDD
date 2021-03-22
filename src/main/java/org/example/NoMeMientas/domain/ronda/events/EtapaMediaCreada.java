package org.example.NoMeMientas.domain.ronda.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.NoMeMientas.domain.ronda.values.Cara;
import org.example.NoMeMientas.domain.ronda.values.EtapaId;

import java.util.ArrayList;
import java.util.List;

public class EtapaMediaCreada extends DomainEvent {

    private final EtapaId etapaId;
    private final List<Cara> caras;

    public EtapaMediaCreada(EtapaId etapaId, List<Cara> caras) {
        super("nomemientan.ronda.etapaMediaCreada");
        this.etapaId = etapaId;
        this.caras = caras;
    }

    public EtapaId getEtapaId() {
        return etapaId;
    }

    public List<Cara> getCaras() {
        return caras;
    }

    public List<Cara> getCarasVisibles() {

        List<Cara> carasVisibles = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            carasVisibles.add(this.caras.get(i));
        }

        return carasVisibles;
    }
}
