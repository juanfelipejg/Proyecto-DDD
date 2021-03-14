package domain.juego.command;

import co.com.sofka.domain.generic.Command;
import domain.juego.Jugador;
import domain.juego.values.Capital;
import domain.juego.values.JugadorId;
import domain.juego.values.Nombre;

import java.util.Map;
import java.util.Set;

public class CrearJuego implements Command {

    private final Map<JugadorId, Capital> capitales;
    private final Map<JugadorId, Nombre> nombres;

    public CrearJuego(Map<JugadorId, Capital> capitales, Map<JugadorId, Nombre> nombres) {
        this.capitales = capitales;
        this.nombres = nombres;
    }

    public Map<JugadorId, Capital> getCapitales() {
        return capitales;
    }

    public Map<JugadorId, Nombre> getNombres() {
        return nombres;
    }
}
