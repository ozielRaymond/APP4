package electronique;

public class Resistance extends Composant {

    private final double valeur;

    public Resistance(double valeur) {
        this.valeur = valeur;

    }

    @Override
    public double calculerResistance() {
        return valeur;
    }
}
