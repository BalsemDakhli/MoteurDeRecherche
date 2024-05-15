package moteurderecherche;

public class Score implements Comparable<Score> {
    protected String fichier;
    protected int score;
    public Score(String fichier , int score){
        this.fichier= fichier;
        this.score= score;
    } 
    public String getFichier() {
        return fichier;
    }
    public void setFichier(String fichier) {
        this.fichier = fichier ;
    }
    public int getScore() {
        return score;
    }
    
    public void addScore(double score) {
        this.score += score;
    }
    public String toString() {
        return "File: " + fichier + ",Score: " + score + '\n';
    }
    public int compareTo(Score s){
        return this.score-s.score;
    }
    
}
    

    