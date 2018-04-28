package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.Document;
import model.Livre;

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
    
    public static String afficherAuteur(Collection<Document> docs){
            StringBuilder biblio = new StringBuilder();
            int tmp = 1;
            List<String> auteurs = new ArrayList();
            for(Document document : docs){
                if(document instanceof Livre){
                    Livre livre = (Livre) document;
                    for(String a : auteurs){
                        if(livre.getAuteur().compareTo(a) == 0){
                            tmp = 0;
                            break;
                        }      
                    }
                    if(tmp == 1)
                        auteurs.add(livre.getAuteur());
                    tmp = 1;
                }
            }
            for(String a : auteurs){
                biblio.append(a);
            }
            return biblio.toString();
        }
	
}
