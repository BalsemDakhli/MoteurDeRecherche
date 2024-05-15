package moteurderecherche.ordonnonceur;

import java.util.List;

import moteurderecherche.Score;
import moteurderecherche.Stat;

public abstract class Ordonnanceur {
    public Ordonnanceur(){

    }
    
    public abstract List<Score>Ordonnancer(List<Stat> stats);
        
        
    
}
