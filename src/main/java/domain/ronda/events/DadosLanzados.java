package domain.ronda.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.ronda.values.Cara;
import java.util.List;

public class DadosLanzados extends DomainEvent {

    private final List<Cara> caras;

    public DadosLanzados(List<Cara> caras) {
        super("NoMeMientas.domain.dadosLanzados");
        this.caras = caras;
    }

    public List<Cara> getCaras() {
        return caras;
    }
}
