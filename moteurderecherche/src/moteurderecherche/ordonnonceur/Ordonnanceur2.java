package moteurderecherche.ordonnonceur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import moteurderecherche.Score;
import moteurderecherche.Stat;

public class Ordonnanceur2 extends Ordonnanceur {
    public Ordonnanceur2(){} 
    public  List<Score> Ordonnancer(List<Stat> stats) {
       // Map pour stocker les occurrences de chaque fichier
        Map<String, Integer> occurencesParFichier = new HashMap<>();

        // Compter le nombre de mots de la requête présents dans chaque fichier
        for (Stat stat : stats) {
            String fichier = stat.getFichier();
            occurencesParFichier.put(fichier, occurencesParFichier.getOrDefault(fichier, 0) + 1);
        }

        // Liste pour stocker les scores calculés
        List<Score> scores = new ArrayList<>();

        // Calculer le score pour chaque fichier
        for (Map.Entry<String, Integer> entry : occurencesParFichier.entrySet()) {
            String fichier = entry.getKey();
            int nombreMotsDansFichier = entry.getValue();

            // Ajouter le score à la liste
            scores.add(new Score(fichier, nombreMotsDansFichier));
        }
        return scores;
    }
}	
	
    
        