package org.example.NoMeMientas.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String nombre;

    public Nombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if(nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no debe estar vacío");
        }

    }
    public String value() {
        return nombre;
    }
}
