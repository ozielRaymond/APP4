package app;

import electronique.*;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;


public class CircuitBuilder {

    private Composant lireCircuit(JsonNode node) {

        String type = node.get("type").asText();

        if("resistance".equals(type)) {
            return new Resistance(node.get("valeur").asDouble());
        }

        else if ("serie".equals(type) || "parallele".equals(type)) {

            List<Composant> circuits = new ArrayList<>();
            for (JsonNode composantNode : node.get("composants")) {
                circuits.add(lireCircuit(composantNode));
            }

            if("serie".equals(type)) {
                return new CircuitSerie(circuits);
            }

            else {
                return new CircuitParallele(circuits);
            }
        }

        throw new IllegalArgumentException("Typer de circuit inconnu : " + type);


    }


}
