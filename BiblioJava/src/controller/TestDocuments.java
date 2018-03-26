package controller;

import model.Bibliotheque;
import model.Document;
import model.Livre;
import model.Manuel;
import model.Revue;
import model.Roman;

public class TestDocuments {

	/**
	 * Programme de test.
	 */
	public static void main(String[] args) {

		Document[] documents = {
			new Livre("L'archipel du Goulag", "Soljenitsyne", 250),
			new Roman("Rouge Brésil", "Rufin", 120, Roman.GONCOURT),
			new Revue("Le point", 03, 2014),
			new Roman("Le mendiant", "Wiesel", 150, Roman.MEDICIS),
			new Livre("La condition humaine", "Malraux", 130),
			new Manuel("Manuel qualité ISO 9001", "AFNOR", -1, 3)
		};
	
		for ( Document doc : documents ) {
			System.out.println(doc);
		}
		
	}

}
