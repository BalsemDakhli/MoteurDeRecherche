package moteurderecherche;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import moteurderecherche.analyseur.Analyseur;
import moteurderecherche.index.*;
import moteurderecherche.lecteur.*;
import moteurderecherche.ordonnonceur.*;
import moteurderecherche.traiteur.Traiteur;

public class MoteurDeRecherche{
    //only use les super classe fel attribut
    //constructeur takes classes concraites
    private  Index index;
    private  Ordonnanceur ordonnanceur;//calculateur de score 
    private  Lecteur lecteur;
    private  Set<Traiteur> traiteur;
    private  Analyseur analyseur;
    public MoteurDeRecherche(Index i, Ordonnanceur ordonnanceur, Lecteur lecteur2,Set<Traiteur> traiteurs,Analyseur analyseur2){
        this.index=i;
        this.ordonnanceur=ordonnanceur;
        this.lecteur=lecteur2;
        this.traiteur=traiteurs;
        this.analyseur=analyseur2;
       }
 
public void index(String chemin){
            File filePath = Paths.get(chemin).toFile();
            if(filePath.exists()){
                if(filePath.isDirectory()){
                    System.out.println(chemin+" is a directory");
                    indexDirectory(chemin);
                }else{
                    System.out.println(chemin+" is a file");
                    indexSingleDocument(chemin);
                }
            }else{
                System.out.println(chemin+" does not exist");
            }
            
        }

        private void indexSingleDocument(String chemin){
            List <String> textRead = new ArrayList<String>();
            List <String> textTreated = new ArrayList<String>();
            List <MotEtOccurence> ListMotEtOcc = new ArrayList<MotEtOccurence>();
            List <Stat> statList = new ArrayList<Stat>();
            String langue ="En";
            textRead=lecteur.Lire(chemin);
            for(Traiteur t:this.traiteur){
                textTreated = t.Traiter(textRead, langue);
            }
            ListMotEtOcc = this.analyseur.Analyser(textTreated);
            for (MotEtOccurence obj : ListMotEtOcc){
                statList.add( new Stat(obj.getMot(),obj.getOccurence(),chemin));
            }
            this.index.getList().addAll(statList);
            
        }

        private void indexDirectory(String chemin){
            File pathFile = Paths.get(chemin).toFile();
            File[] files = pathFile.listFiles();
            for(File f: files ){

                if(f.isDirectory()){
                    indexDirectory(f.getAbsolutePath());
                }else{
                    indexSingleDocument(f.getAbsolutePath());
                }
            }
        }

        public List<String> rechercher(List<String> requete){
        
            List<Stat> result = new ArrayList<Stat>();
            for (String m:requete){
                for( Stat s: index.getList()){
    
    
                    if(s.getMot().equals(m)){
                        result.add(s);
    
    
                    }
              
            }
    
    
        }
        List<Score> orderedScores = ordonnanceur.Ordonnancer(result);
        Collections.sort(orderedScores); // Trie la liste dans l'ordre croissant
        Collections.reverse(orderedScores); // Inverse la liste pour obtenir l'ordre décroissant
    
        List<String> orderedFiles= new ArrayList<String>();
        for (Score s:orderedScores){
            orderedFiles.add(s.getFichier());
        }
    
        return orderedFiles;
}
}