package view;

import java.util.Collection;
import model.Document;

/**
 *  Cette classe contient des méthodes servant à l'affichage d'une partie d'une bibliothèque
 *  (un certain nombre de documents).
 * @author Kilian
 */
public interface Affichage {

    /**
     * Convertie l'affichage d'une liste de documents en string.
     * @param docs
     *      La liste de documents à afficher
     * @return 
     *      un élement de type String affichant plusieurs documents.
     */
    public static String afficherDocument(Collection<Document> docs){
            StringBuilder biblio = new StringBuilder();
            for(Document document : docs){
                biblio.append(document);
            }
            return biblio.toString();
        }
	
}
