package usecase.ronda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.ronda.events.DadosLanzados;
import domain.ronda.values.EtapaId;

public class CrearEtapaUseCase extends UseCase<TriggeredEvent<DadosLanzados>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<DadosLanzados> dadosLanzadosTriggeredEvent) {

        var event = dadosLanzadosTriggeredEvent.getDomainEvent();
        var etapaId = new EtapaId();

    }
}
