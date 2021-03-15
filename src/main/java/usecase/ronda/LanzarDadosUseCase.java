package usecase.ronda;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.ronda.Dado;
import domain.ronda.Ronda;
import domain.ronda.events.RondaCreada;
import domain.ronda.values.DadoId;
import domain.ronda.values.RondaId;

public class LanzarDadosUseCase extends UseCase<TriggeredEvent<RondaCreada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<RondaCreada> rondaCreadaTriggeredEvent) {

        var event = rondaCreadaTriggeredEvent.getDomainEvent();
        var ronda = Ronda.from(RondaId.of(event.aggregateRootId()), retrieveEvents());
        var dadoId = new DadoId();
        var dado = new Dado(dadoId);
        dado.lanzarDado();
        try{
            ronda.lanzarDados(dado.caras());
            emit().onResponse(new ResponseEvents(ronda.getUncommittedChanges()));
        } catch (RuntimeException e){
            emit().onError(new BusinessException(ronda.identity().value(), e.getMessage()));
        }

    }
}
