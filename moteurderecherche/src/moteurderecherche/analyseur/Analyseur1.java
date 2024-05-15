package moteurderecherche.analyseur;

import java.util.ArrayList;
import java.util.List;

import moteurderecherche.MotEtOccurence;

public class Analyseur1 extends Analyseur{
    public Analyseur1(){}
    
    
    public List<MotEtOccurence> Analyser(List<String> doc){
        
        List<MotEtOccurence> MotOcc = new ArrayList<MotEtOccurence>();
        for (String mot : doc){
            MotEtOccurence Autmotocc =new MotEtOccurence(mot, 0);
            int pos = MotOcc.indexOf(Autmotocc);
            if ( pos >=0){
               
                MotOcc.get(pos).setOccurence(MotOcc.get(pos).getOccurence() + 1);
                  
                  
              
            }
            else{
                
                MotEtOccurence i = new MotEtOccurence(mot, 1); 
                MotOcc.add(i);
            }
        }
        return MotOcc;
    }
}
