package electronique;

public class CircuitParallele extends Circuit {

    @Override
    public double calculerResistance() {
        double resistanceInverse = 0;

        for (Composant composant : composants) {
            resistanceInverse += 1 / composant.calculerResistance();
        }

        return 1 / resistanceInverse;
    }
}
