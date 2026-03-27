package electronique;

import java.util.List;

public class CircuitSerie extends Circuit{
    private List<Composant> composants;

    public CircuitSerie(List<Composant> composants) {
        this.composants = composants;
    }

    @Override
    public double calculerResistance() {
        return 0;
    }
}
