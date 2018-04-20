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

public class Bibliotheque {

	// Liste des documents de la bibliotheque
	private List<Document> documents;
        
	/**
	 * Constructeur d'une bibliotheque dont la liste de documents est vide.
	 */
	public Bibliotheque() {
            Document.Nb_Enreg = 0;
                //this.documents = Collections.<Document>emptyList();
                this.documents = new ArrayList<Document>();
                //throw new RuntimeException("Bibliotheque() not yet implemented"); 
	}
	
        public Bibliotheque(List<Document> documents){
            this.documents = documents;
        }
        
	/**
	 * Renvoie la liste des documents de la bibliotheque.
	 */
	public List<Document> getDocuments() {
		return documents;
	}
        
        public List<Document> getLivres() {
            List<Document> tmp = new ArrayList();
            for(Document document : documents){
                if((document instanceof Livre) && (document instanceof Roman) == false && (document instanceof Manuel) == false)
                    tmp.add(document);
            }
            return tmp;
	}
        
        public List<Document> getRomans() {
            List<Document> tmp = new ArrayList();
            for(Document document : documents){
                if(document instanceof Roman)
                    tmp.add(document);
            }
            return tmp;
	}
        
        public List<Document> getManuels() {
            List<Document> tmp = new ArrayList();
            for(Document document : documents){
                if(document instanceof Manuel)
                    tmp.add(document);
            }
            return tmp;
	}
        
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
        
        public void sortTitre(){
            Collections.sort(this.documents, TriDocuments.TITRE);
        }
        
        public void sortAuteur(){
            Collections.sort(this.documents, TriDocuments.AUTEUR);
        }
        
        public void recherchePrixLitt(Roman Prix){
            List<Document> listDoc = new ArrayList<Document>();
            for(Document document : documents){
                if(document instanceof Roman){
                    Roman roman = (Roman) document;
                    if(roman.getPrixLitteraire() == Prix)
                        listDoc.add(document);
                }
            }
            for(Document doc : listDoc){
                System.out.println(doc);
            }
        }
        
        public List<Document> rechercheTitre(String titre){
            List<Document> listDoc = new ArrayList<Document>();
            for(Document document : documents){
                if(document.getTitre().contains(titre))
                    listDoc.add(document);
            }
            return listDoc;
        }
        
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
	 * Sauvegarde la bibliothèque dans un fichier CSV.
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
                                    file.print(roman.getPrixLitt()+";;");
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
}
