package view;

import java.util.Comparator;
import model.Document;

public interface TriDocuments {
    static final Comparator<Document>TITRE = 
            new Comparator<Document>() {
                @Override
                public int compare(Document doc1, Document doc2){
                        String doc1Titre = doc1.getTitre();
                        String doc2Titre = doc2.getTitre();
                        
                        return doc1Titre.compareTo(doc2Titre);
                }
            };
}
