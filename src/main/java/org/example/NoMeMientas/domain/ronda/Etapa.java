package org.example.NoMeMientas.domain.ronda;

import co.com.sofka.domain.generic.Entity;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.ronda.values.Cara;
import org.example.NoMeMientas.domain.ronda.values.Case;
import org.example.NoMeMientas.domain.ronda.values.EtapaId;

import java.util.*;

public class Etapa extends Entity<EtapaId> {

    private final List carasVisibles;
    private final Map<JugadorId, Case> cases;

    public Etapa(EtapaId entityId, List<Cara> carasVisibles) {
        super(entityId);
        this.carasVisibles = carasVisibles;
        this.cases = new HashMap<>();
    }

    public void agregarCaraVisible(Cara cara) {
        carasVisibles.add(cara);
    }

    public void aggregarCases(JugadorId jugadorId, Case aCase) {
        this.cases.put(jugadorId, aCase);
    }

    public Map<JugadorId, Case> cases() {
        return cases;
    }

    public List carasVisibles() {
        return carasVisibles;
    }
}
