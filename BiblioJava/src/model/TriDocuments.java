package model;

import java.util.Comparator;
import model.Document;
import model.Revue;
import model.Livre;

/**
 *
 * @author Kilian
 */
public interface TriDocuments {

    /**
     *
     */
    static final Comparator<Document>TITRE = 
            new Comparator<Document>() {
                @Override
                public int compare(Document doc1, Document doc2){
                        String doc1Titre = doc1.getTitre();
                        String doc2Titre = doc2.getTitre();
                        
                        return doc1Titre.compareTo(doc2Titre);
                }
            };
    
    /**
     *
     */
    static final Comparator<Document>AUTEUR = 
            new Comparator<Document>() {
                @Override
                public int compare(Document doc1, Document doc2){
                    if(!(doc1 instanceof Revue) && !(doc2 instanceof Revue)){
                        Livre document1 = (Livre) doc1;
                        Livre document2 = (Livre) doc2;
                        String doc1Auteur = document1.getAuteur();
                        String doc2Auteur = document2.getAuteur();
                        
                        return doc1Auteur.compareTo(doc2Auteur);
                    }
                    else
                        return -1;
                }
            };
}
