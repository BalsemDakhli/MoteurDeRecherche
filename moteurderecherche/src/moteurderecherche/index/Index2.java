package moteurderecherche.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import moteurderecherche.Stat;

public class Index2 extends Index{
    protected  List<Stat> listeStatique; 
    protected  Map<String,List<Stat>> statmap;
    public Index2(List<Stat> listeStatique){
        this.listeStatique = listeStatique;
        this.statmap = new HashMap<String,List<Stat>>();
        buildStatMap();
    }
    private void buildStatMap() {
        for (Stat stat : listeStatique) {
            String mot = stat.getMot();
            statmap.computeIfAbsent(mot, k -> new ArrayList<>()).add(stat);
        }
    }
    public List<Stat> getList() {
        return listeStatique;
    }
    public  void setListeStatique(List<Stat> listeStatique) {
        this.listeStatique = listeStatique;
    }
   
    public List<Stat> getStatMot(String mot){
         return statmap.get(mot);
    }
    
}
