package moteurderecherche.lecteur;

import java.util.List;

public abstract class Lecteur{
    public Lecteur(){}
    public abstract List<String> Lire(String chemin);

}
