package moteurderecherche.traiteur;

import java.util.ArrayList;
import java.util.List;

public class Decomposeur extends Traiteur{

    
    public List<String> Traiter(List<String> texte , String langue) {
        if (langue == null) {
            langue = "En"; // Par défaut, la langue est le français
        }

        List<String> mots = new ArrayList<>();
        for (String ligne : texte) {
            // Décompose chaque ligne en mots en utilisant des espaces et ponctuations comme délimiteurs
            String[] tokens = ligne.split("\\W+");
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    mots.add(token);
                }
            }
        }
        return mots;

        
    }
    public List<String> TraiterRequete(String R){
        List<String> mots = new ArrayList<>();
        String[] tokens = R.split("\\W+");
        for (String token : tokens) {
            if (!token.isEmpty()) {
                mots.add(token);
            }
        }
        return mots;
    }
}    


