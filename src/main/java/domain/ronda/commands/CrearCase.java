package domain.ronda.commands;

import co.com.sofka.domain.generic.Command;
import domain.juego.values.JugadorId;
import domain.ronda.values.Adivinanza;
import domain.ronda.values.Apuesta;

public class CrearCase implements Command {

    private final JugadorId jugadorId;
    private final Adivinanza adivinanza;
    private final Apuesta apuesta;


    public CrearCase(JugadorId jugadorId, Adivinanza adivinanza, Apuesta apuesta) {
        this.jugadorId = jugadorId;
        this.adivinanza = adivinanza;
        this.apuesta = apuesta;
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
