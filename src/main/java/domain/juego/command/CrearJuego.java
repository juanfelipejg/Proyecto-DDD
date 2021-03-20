package domain.juego.command;

import co.com.sofka.domain.generic.Command;
import domain.juego.Jugador;
import domain.juego.values.Capital;
import domain.juego.values.JuegoId;
import domain.juego.values.JugadorId;
import domain.juego.values.Nombre;

import java.util.Map;
import java.util.Set;

public class CrearJuego implements Command {

    private final JuegoId juegoId;
    private final Map<JugadorId, Capital> capitales;
    private final Map<JugadorId, Nombre> nombres;

    public CrearJuego(JuegoId juegoId,Map<JugadorId, Capital> capitales, Map<JugadorId, Nombre> nombres) {
        this.juegoId = juegoId;
        this.capitales = capitales;
        this.nombres = nombres;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }

    public Map<JugadorId, Capital> getCapitales() {
        return capitales;
    }

    public Map<JugadorId, Nombre> getNombres() {
        return nombres;
    }
}
