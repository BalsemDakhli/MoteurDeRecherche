import java.util.*;

import moteurderecherche.MoteurDeRecherche;
import moteurderecherche.analyseur.*;
import moteurderecherche.index.*;
import moteurderecherche.lecteur.*;
import moteurderecherche.ordonnonceur.*;
import moteurderecherche.traiteur.*;

public class App {
    public static void main(String[] args) {
        // Initialize variables
        Lecteur lecteur = null;
        Set<Traiteur> traiteurs = new HashSet<>();
        Ordonnanceur ordonnanceur = null;
        Analyseur analyseur = null;
        Index index = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choix du lecteur");
        System.out.println("1. Lecteur Ligne Par Ligne");
        System.out.println("2. Lecteur Mot Par Mot");
        System.out.println("3. par defaut");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        switch (choice) {
            case 1:
                lecteur = new Lecteurligne();
                break;
            case 2:
                lecteur = new Lecteurmot();
                break;
            default:
                lecteur = new Lecteurmot();
        }

        do {
            System.out.println("Choix du traiteur:");
            System.out.println("1. pour supprimer les mots vides");
            System.out.println("2. pour rendre le texte miniscule");
            System.out.println("3. pour decomposer les phrases");
            System.out.println("4. par defaut");
            System.out.println("5. Fin choix");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    traiteurs.add(new Nettoyeur());
                    break;
                case 2:
                    traiteurs.add(new Normaliseur());
                    break;
                case 3:
                    traiteurs.add(new Decomposeur());
                    break;
                default:
                    traiteurs.add(new Nettoyeur());
                    traiteurs.add(new Normaliseur());
                    traiteurs.add(new Decomposeur());
                    break;
            }
        } while (choice != 5 && choice != 4);

        System.out.println("choix d'analyseur:");
        System.out.println("1. Analyseur qui utilise les lists");
        System.out.println("2. Analyseur qui utilise les maps");
        System.out.println("3. Analyseur qui utilise sorted list");
        System.out.println("4. par defaut");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        switch (choice) {
            case 1:
                analyseur = new Analyseur1();
                break;
            case 2:
                analyseur = new Analyseur2();
                break;
            case 3:
                analyseur = new Analyseur3();
                break;
            default:
                analyseur = new Analyseur2();
        }

        System.out.println("Choix d'index:");
        System.out.println("1. index qui utilise List");
        System.out.println("2. index qui utilize Map");
        System.out.println("3. par defaut");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        switch (choice) {
            case 1:
                index = new Index1();
                break;
            case 2:
                index = new Index2(new ArrayList<>());
                break;
            default:
                index = new Index2(new ArrayList<>());
        }

        System.out.println("choix d'ordonnanceur");
        System.out.println("1. Ordonanceur qui calcule le score en fonction du nombre d'occurence de chaque mot");
        System.out.println("2. Ordonanceur qui calcule le score en fonction du nombre de mots de requete figurant dans chaque fichier");
        System.out.println("3.par defaut");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        switch (choice) {
            case 1:
                ordonnanceur = new Ordonnanceur1();
                break;
            case 2:
                ordonnanceur = new Ordonnanceur2();
                break;
            default:
                ordonnanceur = new Ordonnanceur1();
        }

        Decomposeur decomposeur = new Decomposeur();

        MoteurDeRecherche moteur = new MoteurDeRecherche(index, ordonnanceur, lecteur, traiteurs, analyseur);
        moteur.index("C://Users//souha//Downloads//tres_petit_corpus//tres_petit_corpus");

        System.out.println("Entrer la requete:");
        String requete = scanner.nextLine();

        while (!requete.equals("END")) {
            List<String> R = decomposeur.TraiterRequete(requete);
            List<String> results = moteur.rechercher(R);
            int count = 0;
            for (String result : results) {
                if (count < 15) {
                    System.out.println(result);
                    count++;
                } else {
                    break;
                }
            }
            System.out.println("Entrer la requete:");
            requete = scanner.nextLine();
        }

        scanner.close();
    }
}