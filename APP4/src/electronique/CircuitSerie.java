package electronique;

import java.util.List;

public class CircuitSerie extends Circuit{
    public CircuitSerie(List<Composant> composants) {
        super(composants);
    }

    @Override
    public double calculerResistance() {
        double resistance = 0.0;
        for (Composant composant : composants) {
            resistance += composant.calculerResistance();
        }

        return resistance;
    }
}
