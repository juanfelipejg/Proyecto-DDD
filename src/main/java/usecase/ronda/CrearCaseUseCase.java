package usecase.ronda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.ronda.Ronda;
import domain.ronda.commands.CrearCase;
import domain.ronda.values.RondaId;

public class CrearCaseUseCase extends UseCase<RequestCommand<CrearCase>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearCase> etapaInicialCreadaRequestCommand) {

        var command = etapaInicialCreadaRequestCommand.getCommand();
        var rondaId = new RondaId();
        var ronda = Ronda.from(rondaId, retrieveEvents());
        ronda.recibirCases(command.getJugadorId(), command.getAdivinanza(), command.getApuesta());
    }
}
