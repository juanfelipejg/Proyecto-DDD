package domain.juego.values;

import co.com.sofka.domain.generic.Identity;

public class JugadorId extends Identity {

    private JugadorId (String id){
        super(id);
    }

    public static JugadorId of(String id){
        return new JugadorId(id);
    }

}
