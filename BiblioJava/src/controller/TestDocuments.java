package controller;

import java.io.FileNotFoundException;
import model.Bibliotheque;
import model.Document;
import model.Livre;
import model.Manuel;
import model.Revue;
import model.Roman;
import model.ReadDocument;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import view.SaisieDocument;
import view.Fenetre;

public class TestDocuments {

	/**
	 * Programme de test.
	 */
	public static void main(String[] args) throws FileNotFoundException {
            
            Bibliotheque biblio = new Bibliotheque();
            Scanner sc = new Scanner(System.in);
            int choix, prix;
            String titre;

		Document[] documents = {
			new Livre("L'archipel du Goulag", "Soljenitsyne", 250),
			new Roman("Rouge Brésil", "Rufin", 120, Roman.GONCOURT),
			new Revue("Le point", 03, 2014),
			new Roman("Le mendiant", "Wiesel", 150, Roman.MEDICIS),
			new Livre("La condition humaine", "Malraux", 130),
			new Manuel("Manuel qualité ISO 9001", "AFNOR", -1, 3)
		};
                
                //SaisieDocument frame = new SaisieDocument();
                for(int i = 0; i < documents.length; i++){
                    biblio.addDocument(documents[i]);
                }
                Fenetre frame = new Fenetre();
               
                // on ajoute les documents dans la bibliothèque        
                /* for(int i = 0; i < documents.length; i++){
                    biblio.addDocument(documents[i]);
                }*/
                
                // on lit dans un fichier
               // ReadDocument file = new ReadDocument("bibliotheque.csv");
                
              //  Bibliotheque biblio2 = new Bibliotheque(file.getDocuments());
                
                
                System.out.println("Bienvenue dans la plus grande bibliothèque au monde !\n");
                System.out.println("[1] Rechercher un document par titre\n");
                System.out.println("[2] Rechercher un document par prix litteraire\n");
                System.out.println("[3] Afficher toute la bibliotheque\n");
                System.out.println("[4] Ajouter un document\n\n");
                System.out.println("Choix : ");
                choix = sc.nextInt();
                
                biblio.exporter();
                switch(choix){
                    case 1 :
                        System.out.println("Saisir un titre : ");
                        titre = sc.nextLine();
                        biblio.rechercheTitre(titre);
                        break;
                    case 2 :
                        System.out.println("Saisir un prix littéraire parmi ceux-ci : \n");
                        System.out.println("[1] GONCOURT\n");
                        System.out.println("[2] MEDICIS\n");
                        System.out.println("Choix : ");
                        prix = sc.nextInt();
                        
                        switch(prix){
                            case 1 : 
                                biblio.recherchePrixLitt(Roman.GONCOURT);
                                break;
                            case 2 :
                                biblio.recherchePrixLitt(Roman.MEDICIS);
                                break;
                        }
                        break;
                    case 3 :
                        //System.out.println(biblio2);
                        break;     
                }
                
                // L'utilisateur entre un titre de document
                
           
                
                
                /*System.out.println("bibliotheque : "+biblio);
                
                biblio.sortTitre();
                
                System.out.println("bibliotheque : "+biblio);*/
		
                /*for ( Document doc : documents ) {
			System.out.println(doc);
                        
		}*/
		
	}

}
