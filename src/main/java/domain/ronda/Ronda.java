package domain.ronda;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.juego.values.JuegoId;
import domain.juego.values.RondaId;
import domain.ronda.values.DadoId;
import domain.ronda.values.EtapaId;

import java.util.Map;

public class Ronda extends AggregateEvent<RondaId> {

    protected JuegoId juegoId;
    protected Map<DadoId, Dado> dados;
    protected Map<EtapaId, Etapa> etapas;
    protected Map<JuegoId, Punto> puntaje;
}
