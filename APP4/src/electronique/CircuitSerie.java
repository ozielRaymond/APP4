package electronique;

public class CircuitSerie extends Circuit{

    @Override
    public double calculerResistance() {
        double resistance = 0;
        for (Composant composant : composants) {
            resistance += composant.calculerResistance();
        }

        return resistance;
    }
}
