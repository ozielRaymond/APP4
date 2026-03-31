package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import electronique.*;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CircuitBuilder {

    public Composant construireCircuit(String chemin) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(new File(chemin));

        return lireComposant(root);
    }

    private Composant lireComposant(JsonNode node) {

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

            for (int i = 0; i < listeComposants.size(); i++) {
                Composant composant = listeComposants.get(i);
                circuitSerie.ajouterComposant(composant);
            }

            return circuitSerie;

        } else if ("parallele".equals(type)) {
            CircuitParallele circuitParallele = new CircuitParallele();

            for (int i = 0; i < listeComposants.size(); i++) {
                Composant composant = listeComposants.get(i);
                circuitParallele.ajouterComposant(composant);
            }

            return circuitParallele;
        }


        throw new IllegalArgumentException("Typer de circuit inconnu : " + type);


    }


}
