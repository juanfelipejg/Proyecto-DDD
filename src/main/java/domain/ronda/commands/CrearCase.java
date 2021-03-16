package domain.ronda.commands;

import co.com.sofka.domain.generic.Command;
import domain.juego.values.JugadorId;
import domain.juego.values.Adivinanza;
import domain.juego.values.Apuesta;
import domain.ronda.values.EtapaId;

public class CrearCase implements Command {

    private final EtapaId etapaId;
    private final JugadorId jugadorId;
    private final Adivinanza adivinanza;
    private final Apuesta apuesta;


    public CrearCase(EtapaId etapaId, JugadorId jugadorId, Adivinanza adivinanza, Apuesta apuesta) {
        this.etapaId = etapaId;
        this.jugadorId = jugadorId;
        this.adivinanza = adivinanza;
        this.apuesta = apuesta;
    }

    public EtapaId getEtapaId() {
        return etapaId;
    }
    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Adivinanza getAdivinanza() {
        return adivinanza;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }
}
