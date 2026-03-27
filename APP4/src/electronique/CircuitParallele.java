package electronique;

import java.util.List;

public class CircuitParallele extends Circuit {
    private List<Composant> composants;

    public CircuitParallele(List<Composant> composants) {
        this.composants = composants;
    }

    @Override
    public double calculerResistance() {
        return 0;
    }
}
