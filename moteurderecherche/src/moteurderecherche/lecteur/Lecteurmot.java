package moteurderecherche.lecteur;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Lecteurmot extends Lecteur {
    public Lecteurmot(){
    }
	@Override
	public  List<String> Lire(String chemin) {
		List<String> mots = new ArrayList<String>();
		BufferedReader br = null;
		try {
			String currentLine;
			br = new BufferedReader(new FileReader(chemin));
			while ((currentLine = br.readLine()) != null) {
				String[] sentenceMots = currentLine.split(" ");
				mots.addAll(Arrays.asList(sentenceMots));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return mots;
	}
    
    

    
}
