package moteurderecherche.index;
import java.util.ArrayList;
import java.util.List;

import moteurderecherche.Stat;

public class Index1 extends Index{
     protected  List<Stat> listeStatique; 
    public Index1(){
        this.listeStatique = new ArrayList<>();
    }
   

   
   public List<Stat> getList(){
    return listeStatique;
   }
   public  void setListeStatique(List<Stat> listeStatique) {
    this.listeStatique = listeStatique;
   }
    public List<Stat> getStatMot(String mot){
        List<Stat> statiqueMot = new ArrayList<Stat>();
        for (Stat stat : listeStatique) {
            if (stat.getMot().equals(mot)) {
                statiqueMot.add(stat);
            }
        }
        return statiqueMot;
    }
    

}

