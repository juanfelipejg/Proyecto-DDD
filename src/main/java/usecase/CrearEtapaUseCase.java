package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.ronda.events.RondaCreada;

public class CrearEtapaUseCase extends UseCase<TriggeredEvent<RondaCreada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<RondaCreada> rondaCreadaTriggeredEvent) {

    }
}
