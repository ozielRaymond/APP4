package electronique;

import java.util.List;

public class CircuitParallele extends Circuit {

    @Override
    public double calculerResistance() {
        double resistance = 0;
        for (Composant composant : composants) {
            resistance += 1 / composant.calculerResistance();
        }

        return resistance;
    }
}
