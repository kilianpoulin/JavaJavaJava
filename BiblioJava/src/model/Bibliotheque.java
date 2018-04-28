package model;

import static java.awt.SystemColor.text;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

/**
 *  Cette classe contient une liste de documents (de tout type).
 * Elle contient de nombreuses fonctions permettant d'ajouter, de supprimer et de trier des documents.
 * @author Kilian
 */
public class Bibliotheque implements Cloneable {

	// Liste des documents de la bibliotheque
	private List<Document> documents;
        
	/**
	 * Constructeur d'une bibliotheque dont la liste de documents est vide.
         * A chaque création de bibliothèque, le numéro d'enregistrement est réinitialisé à 0.
	 */
	public Bibliotheque() {
            Document.Nb_Enreg = 0;
                //this.documents = Collections.<Document>emptyList();
                this.documents = new ArrayList<Document>();
                //throw new RuntimeException("Bibliotheque() not yet implemented"); 
	}
    /**
     * Constructeur d'une bibliotheque à partir d'une liste de documents
     * A chaque création de bibliothèque, le numéro d'enregistrement est réinitialisé à 0.
     * @param documents
     */
    public Bibliotheque(List<Document> documents){
            Document.Nb_Enreg = 0;
            this.documents = documents;
        }
        
	/**
	 * Renvoie la liste des documents de la bibliotheque.
     * @return 
	 */
	public List<Document> getDocuments() {
		return documents;
	}
        
    /**
     *  Renvoie la liste des documents de type "Livre" de la bibliotheque.
     *  Cela exclut également les types Romans et Manuels car des fonctions permettent de les récupérer séparément
     * @return
     */
    public List<Document> getLivres() {
            List<Document> tmp = new ArrayList();
            for(Document document : documents){
                if((document instanceof Livre) && (document instanceof Roman) == false && (document instanceof Manuel) == false)
                    tmp.add(document);
            }
            return tmp;
	}
        
    /**
     *  Renvoie la liste des documents de type "Roman" de la bibliotheque.
     * @return
     *      Une liste de documents (étant en réalité que des romans)
     */
    public List<Document> getRomans() {
            List<Document> tmp = new ArrayList();
            for(Document document : documents){
                if(document instanceof Roman)
                    tmp.add(document);
            }
            return tmp;
	}
        
    /**
     *  Renvoie la liste des documents de type "Manuels" de la bibliotheque.
     * @return
     *  Une liste de documents (étant en réalité que des manuels)
     */
    public List<Document> getManuels() {
            List<Document> tmp = new ArrayList();
            for(Document document : documents){
                if(document instanceof Manuel)
                    tmp.add(document);
            }
            return tmp;
	}
        
    /**
     *  Renvoie la liste des documents de type "Revues" de la bibliotheque.
     * @return
     *  Une liste de documents (étant en réalité que des revues)
     *  
     */
    public List<Document> getRevues() {
            List<Document> tmp = new ArrayList();
            for(Document document : documents){
                if(document instanceof Revue)
                    tmp.add(document);
            }
            return tmp;
	}
        
        /**
	 * Création d'une bibliothèque par défaut au lancement du programme
	 * (permet de tester le programme).
	 */
        public void loadDefaultBiblio(){
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
                    addDocument(documents[i]);
                }
        }

    /**
     * Renvoie le i-ème document de la liste des documents, s'il existe, 
     * ou null sinon.
     * @param i
     *      Numéro du document dans liste.
     * @return 
	 */
	public Document getDocument(int i) {
            if(i > documents.size())
                return null;
                //throw new RuntimeException("getDocument() not yet implemented");  
            else
                return documents.get(i);
	}
	
	/**
	 * Si doc est non null et n'appartient pas déjà à la liste des documents,
	 * alors ajoute doc à cette liste et renvoie true ;
	 * sinon renvoie faux.
     * @param doc
     *      de tyep Document
     * @return 
	 */
	public boolean addDocument(Document doc) {
            // Si doc est null                
            if(null == doc){
                    return false;
                  //throw new RuntimeException("addDocument() not yet implemented");
            }
           
            // Si il le doc appartient déjà à la liste
            for (Document document : documents) {
                if (doc.getNumEnreg() == document.getNumEnreg())
                    return false;
            }
            
            // On ajoute le doc à la liste
            documents.add(doc);
            return true;
             	
	}
	
	/**
	 * Si doc est dans la liste des documents, alors l'y supprime et renvoie true;
	 * sinon renvoie false.
     * @param doc
     *      de type Document
     * @return 
	 */
	public boolean removeDocument(Document doc) {
            // Si il le doc appartient déjà à la liste
            for (Document document : documents) {
                /// le doc se trouve dans la liste des documents
                if (doc.getNumEnreg() == document.getNumEnreg()) {
                    documents.remove(document);
                    return true;
                }    
            }
		//throw new RuntimeException("removeDocument() not yet implemented"); 
                return false;
	}
        
    /**
     *  Tri les documents de la bibliothèque par titre (en utilisant l'interface TriDocuments)
     */
    public void sortTitre(){
            Collections.sort(this.documents, TriDocuments.TITRE);
        }
        
    /**
     *  Tri les documents de la bibliothèque par auteur (en utilisant l'interface TriDocuments)
     */
    public void sortAuteur(){
            Collections.sort(this.documents, TriDocuments.AUTEUR);
        }
        
    /**
     *  Retourne uniquement les documents de la bibliothèque ayant un reçu un certain prix littéraire
     * @param Prix
     *      Prix littéraire que l'on va rechercher (de type Roman)
     * @return
     *      une liste de documents
     */
    public List<Document> recherchePrixLitt(String Prix){
            List<Document> listDoc = new ArrayList<Document>();
            for(Document document : documents){
                if(document instanceof Roman){
                    Roman roman = (Roman) document;
                    if(roman.getPrixLitteraire().compareTo(Prix) == 0)
                        listDoc.add(document);
                }
            }
            return listDoc;
        }
        
    /**
     *  Recherche tous les documents contenant un certain mot ou groupe de mots dans leur titre
     * @param titre
     *      Mot ou groupe de mots (de type String)
     * @return
     *      Une liste de documents.
     */
    public List<Document> rechercheTitre(String titre){
            List<Document> listDoc = new ArrayList<Document>();
            for(Document document : documents){
                if(document.getTitre().contains(titre))
                    listDoc.add(document);
            }
            return listDoc;
        }
        
    /**
     *  Recherche tous les documents contenant un certain mot ou groupe de mots dans le nom de l'auteur
     * @param auteur
     *      Mot ou groupe de mots (de type String)
     * @return
     *      Une liste de documents.
     */
    public List<Document> rechercheAuteur(String auteur){
            List<Document> listDoc = new ArrayList<Document>();
            for(Document document : documents){
                if(document instanceof Livre){
                    Livre livre = (Livre) document;
                    if(livre.getAuteur().contains(auteur))
                    listDoc.add(document);
                }
            }
            return listDoc;
        }
        
        /**
	 * Sauvegarde la bibliothèque dans un fichier CSV nommé "bibliotheque.csv" à la racine du projet.
	 */
        public void exporter() {
            PrintWriter file ;
		try
		{
                        String type = "";
			file = new PrintWriter(new FileWriter("bibliotheque.csv"));
                        file.print("NumEnreg;");
                        file.print("Titre;");
                        file.print("Auteur;");
                        file.print("Nombre de pages;");
                        file.print("Prix Littéraire;");
                        file.print("Niveau;");
                        file.print("Mois;");
                        file.print("Annee;");
                        file.print("Type");
                        file.print("\n");
                        
                        for(Document document : documents){
                            file.print(document.getNumEnreg()+";");
                            file.print(document.getTitre()+";");
                            if(document instanceof Livre){
                                type = "Livre";
                                Livre livre = (Livre) document;
                                file.print(livre.getAuteur()+";");
                                file.print(livre.getNbPages()+";");
                                
                                if(livre instanceof Roman){
                                    type = "Roman";
                                    Roman roman = (Roman) livre;
                                    file.print(roman.getPrixLitteraire()+";;");
                                }
                                else if(livre instanceof Manuel){
                                    type = "Manuel";
                                    Manuel manuel = (Manuel) livre;
                                    file.print(";"+manuel.getNiveau()+";");
                                }
                                else
                                    file.print(";;");
                            }
                            else
                                file.print(";;;;");
                            
                            if(document instanceof Revue){
                                type = "Revue";
                                Revue revue = (Revue) document;
                                file.print(revue.getMois()+";");
                                file.print(revue.getAnnee()+";");
                            }
                            else
                                file.print(";;");
                            file.print(type);
                            file.print("\n");
                        }
			file.flush();
			file.close();
		}
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null");
		}
		catch (IOException a)
		{
			System.out.println("Problème d'IO");
		}
        }
        
	@Override
	public String toString() {
            StringBuilder biblio = new StringBuilder();
            biblio.append("Bibliotheque de " + documents.size() + " documents" + "\n ");
            
            for(Document document : documents){
                biblio.append(document);
            }
            return biblio.toString();
	}	
        
        @Override
        public Bibliotheque clone() throws CloneNotSupportedException {
            Bibliotheque deepBiblio = (Bibliotheque) super.clone();
            deepBiblio.documents = new ArrayList();
       
            for(Document document : documents){
                deepBiblio.addDocument(document.clone());
            }
            
            return deepBiblio;
           
        }
}
