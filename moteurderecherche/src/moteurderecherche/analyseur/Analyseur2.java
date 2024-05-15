package moteurderecherche.analyseur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import moteurderecherche.MotEtOccurence;

public class Analyseur2 extends Analyseur{
    public Analyseur2(){}
        public  List<MotEtOccurence> Analyser(List<String> texte){
          Map<String, Integer> comptages = new HashMap<String,Integer>();
           // compter le nombre d'occurrence de chaque mot
           for (String mot : texte) {
            comptages.put(mot, comptages.getOrDefault(mot, 0) + 1);
           } 
          // Convertir map  en liste MotEtOccurence 
          List<MotEtOccurence> motsOccurrences = new ArrayList<>();
          for (Map.Entry<String, Integer> moocc: comptages.entrySet()) {
            motsOccurrences.add(new MotEtOccurence(moocc.getKey(), moocc.getValue()));
          }
          return motsOccurrences;
        }
         
}
