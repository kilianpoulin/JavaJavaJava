package view;

import java.util.Collection;
import model.Document;

public interface Affichage {

	public static String afficherDocument(Collection<Document> docs){
            StringBuilder biblio = new StringBuilder();
            for(Document document : docs){
                biblio.append(document);
            }
            return biblio.toString();
        }
	
}
