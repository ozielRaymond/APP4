package electronique;

import java.util.ArrayList;
import java.util.List;

public abstract class Circuit extends Composant {
    protected List<Composant> composants = new ArrayList<>();

    public void ajouterComposant(Composant composant) {
        composants.add(composant);
    }

}
