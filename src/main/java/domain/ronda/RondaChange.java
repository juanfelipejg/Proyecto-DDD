package domain.ronda;

import co.com.sofka.domain.generic.EventChange;
import domain.ronda.events.*;
import domain.ronda.values.Case;
import domain.ronda.values.DadoId;

import java.util.HashMap;

public class RondaChange extends EventChange {

    public RondaChange(Ronda ronda) {

        apply((RondaCreada event) -> {
            ronda.juegoId = event.getJuegoId();
            ronda.dados = new HashMap<>();
            ronda.etapas = new HashMap<>();
            ronda.puntaje = new HashMap<>();
            ronda.jugadorIds = event.getJugadorIds();

            for (var i = 1; i <= 6; i++) {//inicializar dados
                ronda.dados.put(DadoId.of(i), new Dado(DadoId.of(i)));
            }
        });

        apply((DadosLanzados event) -> {
            ronda.caras = event.getCaras();
        });

        apply((EtapaInicialCreada event) -> {
            ronda.etapas.put(event.getEtapaId(), new Etapa(event.getEtapaId(), event.getCarasVisibles()));
        });

        apply((CaseCreado event) -> {
            Etapa etapa = ronda.etapas.get(event.getEtapaId());
            etapa.aggregarCases(event.getJugadorId(), new Case(event.getAdivinanza(), event.getApuesta()));
        });

        apply((EtapaMediaCreada event) -> {
            ronda.etapas.put(event.getEtapaId(), new Etapa(event.getEtapaId(), event.getCarasVisibles()));
        });



    }
}
