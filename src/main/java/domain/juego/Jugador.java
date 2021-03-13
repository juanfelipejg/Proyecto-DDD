package domain.juego;

import co.com.sofka.domain.generic.Entity;
import domain.juego.values.Capital;
import domain.juego.values.JugadorId;
import domain.juego.values.Nombre;
import domain.juego.values.Propuesta;

public class Jugador extends Entity<JugadorId> {

    private Nombre nombre;
    private Capital capital;
    private Propuesta propuesta;
    boolean jugandoEtapa;

    public Jugador(JugadorId entityId, Nombre nombre, Capital capital, Propuesta propuesta, boolean jugandoEtapa) {
        super(entityId);
        this.nombre = nombre;
        this.capital = capital;
        this.propuesta = propuesta;
        this.jugandoEtapa = jugandoEtapa;
    }

    public Jugador(JugadorId entityId, Nombre nombre){
        super(entityId);
        this.nombre = nombre;
        this.capital = new Capital(0);
    }

    public Nombre getNombre() {
        return nombre;
    }
}
