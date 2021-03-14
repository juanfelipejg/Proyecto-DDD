package domain.ronda;

import co.com.sofka.domain.generic.Entity;
import domain.juego.values.JugadorId;
import domain.ronda.values.Cara;
import domain.ronda.values.Case;
import domain.ronda.values.EtapaId;

import java.util.Map;
import java.util.Set;

public class Etapa extends Entity<EtapaId> {

    private final Set<Cara> carasvisibles;
    private final Map<JugadorId, Case> cases;
}
