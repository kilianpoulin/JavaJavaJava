package model;


import java.util.List;


public class Bibliotheque {

	// Liste des documents de la bibliotheque
	private List<Document> documents;

	/**
	 * Constructeur d'une bibliotheque dont la liste de documents est vide.
	 */
	public Bibliotheque() {
		// TO DO ... ( "vide" ne veut pas dire null ! )
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

	@Override
	public String toString() {
            StringBuilder biblio = new StringBuilder();
            biblio.append("Bibliotheque de " + documents.size() + " documents" + "\n ");
            
            for(Document document : documents){
                biblio.append(document);
            }
            biblio.append("\n\nFIN BIBLIO -------------------------------------");
            return biblio.toString();
	}	
}
