package domain.juego.values;

import co.com.sofka.domain.generic.Identity;

public class Capital extends Identity {

    private final Integer saldo;

    public Capital(Integer saldo) {
        this.saldo = saldo;
    }
}
