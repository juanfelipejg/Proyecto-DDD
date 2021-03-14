package domain.ronda.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Case implements ValueObject<Case.valor> {

    private final Adivinanza adivinanza;
    private final Apuesta apuesta;

    public Case(Adivinanza adivinanza, Apuesta apuesta) {
        this.adivinanza = Objects.requireNonNull(adivinanza);
        this.apuesta = Objects.requireNonNull(apuesta);
    }

    @Override
    public Valor value() {
        return new Valor() {
            @Override
            public Adivinanza adivinanza() {
                return adivinanza;
            }

            @Override
            public Apuesta apuesta() {
                return apuesta;
            }
        };
    }

    public interface Valor {
        Adivinanza adivinanza();

        Apuesta apuesta();
    }
}