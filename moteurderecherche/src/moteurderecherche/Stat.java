package moteurderecherche;


public class Stat {
    private String Mot ;
    private int Occurence ;
    private String Fichier;
    public Stat(String mot ,int occ,String fichier){
        this.Mot =mot;
        this.Occurence =occ;
        this.Fichier =fichier;
    }
    public String getMot() {
        return Mot;
    }
    public void setMot(String mot) {
        Mot = mot;
    }
    public int getOccurence() {
        return Occurence;
    }
    /*public void setOccurence(int occurence) {
        Occurence = occurence;
    }*/
    public String getFichier() {
        return Fichier;
    }
    public void setFichier(String fichier) {
        this.Fichier = fichier;
    }
    public String toString() {
        return "Mot: " + Mot + ", Occurrence: " + Occurence + ", Fichier: " + Fichier + '\n';
    }
    

    
}
