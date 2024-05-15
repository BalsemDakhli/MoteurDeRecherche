package moteurderecherche.traiteur;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Normaliseur extends Traiteur{
    public Normaliseur(){
    }
    public  List<String> Traiter(List<String> texte,String langue){
        // If langue parameter is not provided, set it to "francais" by default
        if (langue == null || langue.isEmpty()) {
            langue = "En";
        }
        ArrayList<String> normalizedtexte = new ArrayList<String>();
        for (String mot : texte){
           normalizedtexte.add(mot.toLowerCase());
           // Enlever les accents
                mot = Normalizer.normalize(mot, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        }
        return normalizedtexte;
    }
        
    
    
}