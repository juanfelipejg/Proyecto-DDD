package usecase.ronda;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.juego.values.JuegoId;
import domain.ronda.Ronda;
import domain.ronda.events.DadosLanzados;
import domain.ronda.values.EtapaId;
import domain.ronda.values.RondaId;

public class CrearEtapaInicialUseCase extends UseCase<TriggeredEvent<DadosLanzados>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<DadosLanzados> dadosLanzadosTriggeredEvent) {

        var event = dadosLanzadosTriggeredEvent.getDomainEvent();
        var rondaId = new RondaId();
        var ronda = Ronda.from(rondaId, retrieveEvents());
        var etapaId = EtapaId.of(1);
        try{
            ronda.insertarEtapaInicial(etapaId, event.getCaras());
            emit().onResponse(new ResponseEvents(ronda.getUncommittedChanges()));
        } catch (RuntimeException e){
            emit().onError(new BusinessException(ronda.identity().value(), e.getMessage()));
        }

    }
}
