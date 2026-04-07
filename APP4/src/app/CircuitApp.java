package app;

import electronique.Composant;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CircuitApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String path = "src/donnees/fichiers_json";

        while (true) {

            File dossiers = new File(path);
            File[] fichiers = dossiers.listFiles();
            ArrayList<String> fichiersJson = new ArrayList<>();

            if (fichiers != null) {
                for (File fichier : fichiers) {
                    if (fichier.getName().endsWith(".json")) {
                        fichiersJson.add(fichier.getName());
                    }
                }
            } else {
                System.out.println("Aucun fichier détecté dans le dossier");
                break;
            }


            System.out.println("Fichiers disponibles:\n");
            for (int i = 0; i < fichiersJson.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + fichiersJson.get(i));
            }

            int choix = -1;

            while (choix < 1 || choix > fichiersJson.size()) {
                try {
                    System.out.print("\nTaper le numéro du fichier à analyser > ");
                    choix = Integer.parseInt(sc.nextLine());

                    if (choix < 1 || choix > fichiersJson.size()) {
                        System.out.println("Choix invalide");
                    }

                } catch (Exception e) {
                    System.out.println("Choix invalide");
                }

            }

            String nomChoix = fichiersJson.get(choix - 1);
            String pathFichier = path + "/" + nomChoix;

            try {
                Composant circuit = CircuitBuilder.construireCircuit(pathFichier);
                double resistance = circuit.calculerResistance();

                System.out.printf("\nRésistance équivalente du circuit : %.2f Ω\n", resistance);
            } catch (Exception e) {
                System.out.println("Erreur lors du calcul");
            }

            String action;

            while (true) {
                System.out.println("\n[R] Recommencer");
                System.out.println("[Q] Quitter");
                System.out.print("\nEntrez la lettre correspondant à l'action désirée > ");


                action = sc.nextLine().toUpperCase();

                System.out.println();

                if (action.equals("R")) {
                    break;
                } else if (action.equals("Q")) {
                    System.out.println("Vous avez quitté le programme");
                    break;

                } else {
                    System.out.print("! Saisie invalide\n");
                }
            }


            if (action.equals("Q")) {
                break;
            }
        }


    }
}
