package domain.juego.values;

import co.com.sofka.domain.generic.Identity;

public class JuegoId extends Identity {

    //Validación para que el id no sea null
    private JuegoId (String id){
        super(id);
    }

    public JuegoId(){

    }

    public static JuegoId of(String id) {
        return new JuegoId(id);
    }


}
