package app;

import electronique.Composant;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CircuitApp {

    static void main() {
        Scanner sc = new Scanner(System.in);
        final String path = "src/donnees/fichiers_json";

        while (true) {

            File[] fichiers = new File(path).listFiles();

            ArrayList<String> fichiersJson = new ArrayList<>();

            if (fichiers != null) {
                for (File fichier : fichiers) {
                    if (fichier.getName().endsWith(".json")) {
                        fichiersJson.add(fichier.getName());
                    }
                }
            }


            for (int i = 0; i < fichiersJson.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + fichiersJson.get(i));
            }

            int choix;

            while (true) {
                try {
                    System.out.print("Taper le numéro du fichier à analyser: ");
                    choix = Integer.parseInt(sc.nextLine());

                    if (choix >= 1 && choix <= fichiersJson.size()) {
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("choix invalide");
                }

                try {

                    Composant circuit = CircuitBuilder.construireCircuit(path);

                    double resistanceTotal = circuit.calculerResistance();

                    System.out.printf("Résistance équivalente : %.2f Ω\n", resistanceTotal);
                } catch (Exception e) {
                    System.out.println("Erreur lors du calcul.");
                }
            }


            System.out.println("\n[R] Recommencer");
            System.out.println("[Q] Quitter");

            String action = sc.nextLine().toUpperCase();

            if (action.equals("Q")) {
                System.out.println("Vous avez quitté le programme.");
                break;
            }
        }


    }
}
