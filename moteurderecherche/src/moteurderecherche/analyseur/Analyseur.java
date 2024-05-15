package moteurderecherche.analyseur;


import java.util.List;

import moteurderecherche.MotEtOccurence;

public abstract class Analyseur {
    public  Analyseur (){

    }
    public abstract List<MotEtOccurence> Analyser(List<String> texte);
        
       
    
}
