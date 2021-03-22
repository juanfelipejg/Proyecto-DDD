package org.example.NoMeMientas.usecase.ronda;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.NoMeMientas.domain.ronda.Ronda;
import org.example.NoMeMientas.domain.ronda.events.DadosLanzados;
import org.example.NoMeMientas.domain.ronda.values.EtapaId;
import org.example.NoMeMientas.domain.ronda.values.RondaId;

public class CrearEtapaInicialUseCase extends UseCase<TriggeredEvent<DadosLanzados>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<DadosLanzados> dadosLanzadosTriggeredEvent) {

        var event = dadosLanzadosTriggeredEvent.getDomainEvent();
        var ronda = Ronda.from(RondaId.of(event.aggregateRootId()), retrieveEvents());
        var etapaId = EtapaId.of(1);
        try{
            ronda.insertarEtapaInicial(etapaId, event.getCaras());
            emit().onResponse(new ResponseEvents(ronda.getUncommittedChanges()));
        } catch (RuntimeException e){
            emit().onError(new BusinessException(ronda.identity().value(), e.getMessage()));
        }

    }
}
