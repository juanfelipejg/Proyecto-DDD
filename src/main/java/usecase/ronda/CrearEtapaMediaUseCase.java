package usecase.ronda;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.ronda.Ronda;
import domain.ronda.events.EtapaInicialCreada;
import domain.ronda.values.EtapaId;
import domain.ronda.values.RondaId;

public class CrearEtapaMediaUseCase extends UseCase<TriggeredEvent<EtapaInicialCreada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<EtapaInicialCreada> etapaInicialCreadaTriggeredEvent) {

        var event = etapaInicialCreadaTriggeredEvent.getDomainEvent();
        var ronda = Ronda.from(RondaId.of(event.aggregateRootId()), retrieveEvents());
        var etapaId = EtapaId.of(2);
        try{
            ronda.insertarEtapaMedia(etapaId, event.getCaras());
            emit().onResponse(new ResponseEvents(ronda.getUncommittedChanges()));
        } catch (RuntimeException e){
            emit().onError(new BusinessException(ronda.identity().value(), e.getMessage()));
        }

    }
}
