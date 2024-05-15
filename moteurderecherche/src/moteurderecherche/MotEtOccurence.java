package moteurderecherche;

import java.util.Objects;

public class MotEtOccurence {
    private String Mot ;
    private int Occurence;
    public MotEtOccurence(String mot, int occ){
        this.Mot =mot;
        this.Occurence=occ;
    }
    public String getMot(){
        return Mot;
    }
    public void setMot(String mot) {
        Mot = mot;
    }
    public int getOccurence(){
       return Occurence;
    }
    public void setOccurence(int occurence) {
        Occurence = occurence;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotEtOccurence that = (MotEtOccurence) o;
        return Objects.equals(Mot, that.Mot);
    }
    @Override
    public String toString() {
        return "Mot: " + Mot + ", Occurrence: " + Occurence;
    }
}