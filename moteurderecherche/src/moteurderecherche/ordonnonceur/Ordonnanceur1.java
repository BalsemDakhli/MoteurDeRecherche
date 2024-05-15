package moteurderecherche.ordonnonceur;

import java.util.ArrayList;
import java.util.List;

import moteurderecherche.Score;
import moteurderecherche.Stat;

public class Ordonnanceur1 extends Ordonnanceur {
    public  List<Score> Ordonnancer(List<Stat> stats) {
        List<Score> score = new ArrayList<Score>();
        
        for (Stat stat : stats) {
            boolean found = false;
            
            // Recherche du fichier dans la liste des scores existants
            for (Score s : score) {
                if (stat.getFichier().equals(s.getFichier())) {
                    // Si le fichier est trouvé, mettre à jour le score
                    s.addScore(stat.getOccurence());
                    found = true;
                    break;
                }
            }
            
            // Si le fichier n'est pas trouvé dans la liste des scores existants, ajouter un nouveau score
            if (!found) {
                score.add(new Score(stat.getFichier(), stat.getOccurence()));
            }
        }
        return score;
    }
    
}  
