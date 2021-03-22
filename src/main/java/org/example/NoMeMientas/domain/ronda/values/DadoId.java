package org.example.NoMeMientas.domain.ronda.values;

import co.com.sofka.domain.generic.Identity;

public class DadoId extends Identity {

    private DadoId(Integer num) {
        super(num.toString());
    }

    public DadoId(){

    }

    public static DadoId of(Integer num) {
        return new DadoId(num);
    }
}
