package moteurderecherche.traiteur;

import java.util.List;

public abstract class Traiteur {
    public Traiteur(){

    }
    public abstract List<String>Traiter(List<String> texte, String langue);
        
    

}
