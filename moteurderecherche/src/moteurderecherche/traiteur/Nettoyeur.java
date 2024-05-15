package moteurderecherche.traiteur;

import java.util.Arrays;
import java.util.List;

public class Nettoyeur extends Traiteur{
    // Liste des mots vides en français
    private  List<String> motsVidesFr; 
    // Liste des mots vides en anglais
    private List<String> motsVidesEn ;
    public Nettoyeur(){
      this.motsVidesFr = Arrays.asList("le", "la", "les", "de", "du", "des", "un", "une", "et", "ou", "mais", "donc", "car", "pour", "si", "parce", "que", "quand", "où", "comme"); 
      this.motsVidesEn = Arrays.asList("a", "an", "the", "and", "or", "but", "so", "for", "if", "because", "when", "where", "how", "what", "why");
    }
    
    
    public List<String> Traiter(List<String> texte, String langue) {
        // If langue parameter is not provided, set it to "francais" by default
        if (langue == null || langue.isEmpty()) {
            langue = "En";
        }
        for (int i = 0; i < texte.size(); i++) {
            String mot = texte.get(i);
            mot = mot.replaceAll("[^a-zA-ZÀ-ÿ0-9\\s]", ""); // Garder uniquement les lettres, les chiffres et les espaces
                texte.set(i, mot);
            if (langue.equals("fr")) {
              if (motsVidesFr.contains(mot)) {
                   texte.remove(mot);
                   i--; 
                }
            } else if (langue.equals("en")) {
                if (motsVidesEn.contains(mot)) {
                    texte.remove(mot);
                    i--;
                }
            }
        }
        return texte;
    }


    
        
}

