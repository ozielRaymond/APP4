package electronique;

import java.util.List;

public class CircuitParallele extends Circuit {
    public CircuitParallele(List<Composant> composants) {
        super(composants);
    }

    @Override
    public double calculerResistance() {
        double resistance = 0;
        for (Composant composant : composants) {
            resistance += 1 / composant.calculerResistance();
        }

        return resistance;
    }
}
