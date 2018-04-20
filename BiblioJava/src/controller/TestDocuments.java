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
import view.Affichage;
import view.SaisieDocument;
import view.Fenetre;

/**
 *
 * @author Kilian
 */
public class TestDocuments {

    /**
	 * Programme principal contenant le programme console ainsi que le programme en mode graphique (swing)
     * @param args
     * @throws java.io.FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
            
            Bibliotheque biblio = new Bibliotheque();
            Bibliotheque biblio_tmp = null;
            Scanner sc = new Scanner(System.in);
            List<Document> recherche = null;
            int choix, s_prix, s_type, a_nb_pages, a_niveau, a_prix, a_mois, a_annee, t_trier, s_supp;
            String filename;
            String s_titre, s_auteur, a_titre, a_auteur;

            Fenetre frame = new Fenetre();
            // ajout de la bibliotheque par défaut :
            biblio.loadDefaultBiblio();
            
            System.out.println("Bienvenue dans la plus grande bibliothèque au monde !\n");
            System.out.println("\n ** Si vous n'importez pas de bibliothèque, celle par defaut sera utilisée **\n\n");
                
            do{
                
                System.out.println("[0] Importer une bibliotheque\n");
                System.out.println("[1] Rechercher un document (et eventuellement le supprimer)\n");
                System.out.println("[2] Ajouter un document\n");
                System.out.println("[3] Afficher toute la bibliotheque (et la trier)\n");
                System.out.println("[4] QUITTER LE PROGRAMME\n");
                System.out.println("Choix : ");
                choix = sc.nextInt();

                switch(choix){
                    case 0 : // importer une bibliotheque
                        System.out.println("\n => Importation d'une bibliotheque <=\n");
                        System.out.println("Chemin absolu du fichier : ");
                        sc.nextLine();
                        filename = sc.nextLine();
                        if(filename.compareTo("") != 0 && filename.compareTo(" ") != 0){
                            ReadDocument file = new ReadDocument(filename);

                            biblio = new Bibliotheque(file.getDocuments());

                            System.out.println("\nBibliotheque importée avec succès : \n");

                            System.out.println(biblio);
                        } else {
                            System.out.println("Erreur -> Le nom de fichier est vide !");
                        }
                        break;
                    case 1 : // rechercher un document
                        System.out.println("\n => Rechercher un document <=\n");
                        System.out.println("** Saisir '0' pour laisser un champ vide **\n");
                        System.out.println("Titre : ");
                        sc.nextLine();
                        s_titre = sc.nextLine();
                        recherche = biblio.rechercheTitre(s_titre);
                        biblio_tmp = new Bibliotheque(recherche);

                        System.out.println("\nAuteur : ");
                        s_auteur = sc.nextLine();
                        if(s_auteur.compareTo("0") != 0){
                            recherche = biblio_tmp.rechercheAuteur(s_auteur);
                            biblio_tmp = new Bibliotheque(recherche);
                        }

                        System.out.println("Saisir un prix littéraire parmi ceux-ci : \n");
                        System.out.println("[0] Aucun prix\n");
                        System.out.println("[1] GONCOURT\n");
                        System.out.println("[2] MEDICIS\n");
                        System.out.println("[3] RENAUDOT\n");
                        System.out.println("Prix : ");
                        s_prix = sc.nextInt();
                        switch(s_prix){
                            case 1 : 
                                recherche = biblio_tmp.recherchePrixLitt(Roman.GONCOURT);
                                break;
                            case 2 :
                               recherche = biblio_tmp.recherchePrixLitt(Roman.MEDICIS);
                                break;
                            case 3 :
                                recherche = biblio.recherchePrixLitt(Roman.RENAUDOT);
                                break;
                        }

                        System.out.println("\nRésultat de la recherche : \n");
                        System.out.println(Affichage.afficherDocument(recherche));

                        System.out.println("\nSupprimer la sélection ?\n");
                        System.out.println("[0] Non\n");
                        System.out.println("[1] Oui\n");
                        System.out.println("Décision : ");
                        s_supp = sc.nextInt();

                        if(s_supp == 1){
                            for(Document document : recherche){
                                biblio.removeDocument(document);
                            }
                            System.out.println("Documents supprimés avec succès : \n");
                            System.out.println(biblio);
                        }
                        break;
                    case 2 :
                        System.out.println("\n => Ajouter un document <=\n");
                        System.out.println("\n Choisir un type de document à ajouter\n");
                        System.out.println("[0] Livre\n");
                        System.out.println("[1] Roman\n");
                        System.out.println("[2] Manuel\n");
                        System.out.println("[3] Revue\n");
                        System.out.println("Type : ");
                        s_type = sc.nextInt();

                        switch(s_type){
                            case 0 : 
                                System.out.println("\n-> Ajout d'un livre <-\n");
                                System.out.println("Saisir un titre : ");
                                sc.nextLine();
                                a_titre = sc.nextLine();
                                System.out.println("\nSaisir un auteur : ");
                                a_auteur = sc.nextLine();

                                System.out.println("\nSaisir un nombre de pages : ");
                                a_nb_pages = sc.nextInt();

                                biblio.addDocument(new Livre(a_titre, a_auteur, a_nb_pages));

                                System.out.println("\n Livre ajouté avec succès : \n");
                                System.out.println(biblio);
                                break;
                            case 1 : 
                                System.out.println("\n-> Ajout d'un roman <-\n");
                                System.out.println("Saisir un titre : ");
                                sc.nextLine();
                                a_titre = sc.nextLine();
                                System.out.println("\nSaisir un auteur : ");
                                a_auteur = sc.nextLine();

                                System.out.println("\nSaisir un nombre de pages : ");
                                a_nb_pages = sc.nextInt();

                                System.out.println("\nSaisir un prix littéraire parmi ceux-ci : \n");
                                System.out.println("[0] Aucun prix\n");
                                System.out.println("[1] GONCOURT\n");
                                System.out.println("[2] MEDICIS\n");
                                System.out.println("[3] RENAUDOT\n");
                                System.out.println("Prix : ");
                                a_prix = sc.nextInt();

                                switch(a_prix){
                                    case 0 : 
                                        biblio.addDocument(new Roman(a_titre, a_auteur, a_nb_pages));
                                        break;
                                    case 1 : 
                                        biblio.addDocument(new Roman(a_titre, a_auteur, a_nb_pages, Roman.GONCOURT));
                                        break;
                                    case 2 : 
                                        biblio.addDocument(new Roman(a_titre, a_auteur, a_nb_pages, Roman.MEDICIS));
                                        break;
                                    case 3 :
                                        biblio.addDocument(new Roman(a_titre, a_auteur, a_nb_pages, Roman.RENAUDOT));
                                        break;
                                }

                                System.out.println("\n Roman ajouté avec succès : \n");
                                System.out.println(biblio);
                                break;
                            case 2 :
                                System.out.println("\n-> Ajout d'un manuel <-\n");
                                System.out.println("Saisir un titre : ");
                                sc.nextLine();
                                a_titre = sc.nextLine();
                                System.out.println("\nSaisir un auteur : ");
                                a_auteur = sc.nextLine();

                                System.out.println("\nSaisir un nombre de pages : ");
                                a_nb_pages = sc.nextInt();

                                System.out.println("\nSaisir un niveau : ");
                                a_niveau = sc.nextInt();

                                biblio.addDocument(new Manuel(a_titre, a_auteur, a_niveau, a_nb_pages));

                                System.out.println("\n Manuel ajouté avec succès : \n");
                                System.out.println(biblio);
                                break;
                            case 3 : 
                                System.out.println("\n-> Ajout d'une revue <-\n");
                                System.out.println("Saisir un titre : ");
                                sc.nextLine();
                                a_titre = sc.nextLine();
                                System.out.println("\nSaisir le mois de parution : ");
                                a_mois = sc.nextInt();

                                System.out.println("\nSaisir l'annee de parution : ");
                                a_annee = sc.nextInt();

                                biblio.addDocument(new Revue(a_titre, a_mois, a_annee));

                                System.out.println("\n Revue ajoutée avec succès : \n");
                                System.out.println(biblio);
                                break;
                        }
                        break;
                    case 3 :
                        System.out.println("\n => Afficher la bibliothèque et la trier <=\n");

                        System.out.println(biblio);

                        System.out.println("\nPour trier la bibliothèque, choisir une option : \n");
                            System.out.println("[0] Par titre\n");
                            System.out.println("[1] Par auteur\n");
                            System.out.println("[2] Afficher que les LIVRES\n");
                            System.out.println("[3] Afficher que les ROMANS\n");
                            System.out.println("[4] Afficher que les MANUELS\n");
                            System.out.println("[5] Afficher que les REVUES\n");
                            System.out.println("Choix : ");
                            t_trier = sc.nextInt();
                            switch(t_trier){
                                case 0 : 
                                    biblio.sortTitre();
                                    System.out.println("Tri effectué : \n");
                                    System.out.println(biblio);
                                    break;
                                case 1 :
                                    biblio.sortAuteur();
                                    System.out.println("Tri effectué : \n");
                                    System.out.println(biblio);
                                    break;
                                case 2 : 
                                    biblio_tmp = new Bibliotheque(biblio.getLivres());
                                    System.out.println("Tri effectué : \n");
                                    System.out.println(biblio_tmp);
                                    break;
                                case 3 : 
                                    biblio_tmp = new Bibliotheque(biblio.getRomans());
                                    System.out.println("Tri effectué : \n");
                                    System.out.println(biblio_tmp);
                                    break;
                                case 4 : 
                                    biblio_tmp = new Bibliotheque(biblio.getManuels());
                                    System.out.println("Tri effectué : \n");
                                    System.out.println(biblio_tmp);
                                    break;
                                case 5 : 
                                    biblio_tmp = new Bibliotheque(biblio.getRevues());
                                    System.out.println("Tri effectué : \n");
                                    System.out.println(biblio_tmp);
                                    break;
                            }
                            break;
                }

            }while(choix < 4);
            
            System.out.println(" => FIN DU PROGRAMME <= \n Pensez à fermer la fenêtre !");
        }

}
