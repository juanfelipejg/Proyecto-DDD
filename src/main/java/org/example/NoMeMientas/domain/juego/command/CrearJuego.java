package org.example.NoMeMientas.domain.juego.command;

import co.com.sofka.domain.generic.Command;
import org.example.NoMeMientas.domain.juego.values.Capital;
import org.example.NoMeMientas.domain.juego.values.JuegoId;
import org.example.NoMeMientas.domain.juego.values.JugadorId;
import org.example.NoMeMientas.domain.juego.values.Nombre;

import java.util.Map;

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
