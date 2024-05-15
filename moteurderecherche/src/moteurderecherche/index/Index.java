package moteurderecherche.index;

import java.util.List;

import moteurderecherche.Stat;

public abstract class Index {
   protected Index(){

   }
   
    public  abstract List<Stat> getStatMot(String mot);

    public abstract List<Stat> getList();
       
    
}
