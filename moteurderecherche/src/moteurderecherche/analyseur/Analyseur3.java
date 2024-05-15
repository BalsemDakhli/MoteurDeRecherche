package moteurderecherche.analyseur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import moteurderecherche.MotEtOccurence;

public class Analyseur3 extends Analyseur{ 
    public Analyseur3(){}
    public List<MotEtOccurence> Analyser(List<String> doc){

        // Triez la liste de mots par ordre alphabétique
        Collections.sort(doc);

        // Liste pour stocker les mots et leurs occurrences
        List<MotEtOccurence> motsOccurrences = new ArrayList<>();
        String motPrecedent = null;
        int occurrence = 0;
        // Parcourez la liste triée
        for (String mot : doc) {
            if (motPrecedent == null || !motPrecedent.equals(mot)) {
                // Si le mot est différent du précédent, créez une nouvelle instance MotEtOccurence
                if (motPrecedent != null) {
                    motsOccurrences.add(new MotEtOccurence(motPrecedent, occurrence));
                }
                motPrecedent = mot;
                occurrence = 1;
            } else {
                // Si le mot est le même que le précédent, incrémente le nombre d'occurrences
                occurrence++;
            }
        }return motsOccurrences;

    
    
    }
}
