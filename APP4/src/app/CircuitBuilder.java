package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import electronique.*;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CircuitBuilder {

    public static Composant construireCircuit(String chemin) throws Exception {

        return lireComposant(new ObjectMapper().readTree(new File(chemin)).get("circuit"));
    }

    private static Composant lireComposant(JsonNode node) {

        String type = node.get("type").asText();

        if ("resistance".equals(type)) {
            return new Resistance(node.get("valeur").asDouble());
        }

        List<Composant> listeComposants = new ArrayList<>();

        for (JsonNode composantNode : node.get("composants")) {
            listeComposants.add(lireComposant(composantNode));
        }

        if ("serie".equals(type)) {
            CircuitSerie circuitSerie = new CircuitSerie();

            for (Composant composant : listeComposants) {
                circuitSerie.ajouterComposant(composant);
            }

            return circuitSerie;

        } else if ("parallele".equals(type)) {
            CircuitParallele circuitParallele = new CircuitParallele();

            for (Composant composant : listeComposants) {
                circuitParallele.ajouterComposant(composant);
            }

            return circuitParallele;
        }


        throw new IllegalArgumentException("Typer de circuit inconnu : " + type);


    }


}
