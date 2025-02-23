package moteurderecherche.lecteur;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lecteurligne extends Lecteur {
    public Lecteurligne(){}
	@Override
	public List<String> Lire(String chemin) {
		List<String> words = new ArrayList<String>();
		BufferedReader br = null;
		try {
		
			String currentLine;
			br = new BufferedReader(new FileReader(chemin));
			
			while ((currentLine = br.readLine()) != null) {
				words.add(currentLine);
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

		return words;
	}

	

}