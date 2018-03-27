package controller;

import model.Bibliotheque;
import model.Document;
import model.Livre;
import model.Manuel;
import model.Revue;
import model.Roman;
import java.util.List;
import java.util.ArrayList;


public class TestDocuments {

	/**
	 * Programme de test.
	 */
	public static void main(String[] args) {
            
            Bibliotheque biblio = new Bibliotheque();

		Document[] documents = {
			new Livre("L'archipel du Goulag", "Soljenitsyne", 250),
			new Roman("Rouge Brésil", "Rufin", 120, Roman.GONCOURT),
			new Revue("Le point", 03, 2014),
			new Roman("Le mendiant", "Wiesel", 150, Roman.MEDICIS),
			new Livre("La condition humaine", "Malraux", 130),
			new Manuel("Manuel qualité ISO 9001", "AFNOR", -1, 3)
		};
               
                        
                for(int i = 0; i < documents.length; i++){
                    biblio.addDocument(documents[i]);
                }
                biblio.removeDocument(documents[2]);
                
                System.out.println(biblio.getDocument(1));
                
                
                System.out.println("bibliotheque : "+biblio);
		
                /*for ( Document doc : documents ) {
			System.out.println(doc);
                        
		}*/
		
	}

}
