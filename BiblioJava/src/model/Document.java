package model;

// TO DO ...

/**
 *  Cette classe contient tous les élements caractérisant un Document, y compris son affichage.
 *  Au total, elle a quatre sous-classes (ROMAN, MANUEL, REVUE, LIVRE)
 * @author Kilian
 */
public abstract class Document implements Cloneable {
	
    /**
     *  Chaque document a un numéro référence (son ordre d'enregistrement).
     */
    public static int Nb_Enreg = 0;
    private int numEnreg;
    private String titre;

    /**
     *  Constructeur permettant de créer un document vide. 
     *  Le numéro d'enregistrement est incrémenté à CHAQUE création de document
     */
    public Document(){
        this.numEnreg = Nb_Enreg;
        Nb_Enreg++;
    }
    
    /**
     *  Constructeur permettant de créer un document. 
     *  Le numéro d'enregistrement est incrémenté à CHAQUE création de document.
     * @param titre
     *      Titre du document (string)
     */
    public Document(String titre){
        this.titre = titre;
        this.numEnreg = Nb_Enreg;
        Nb_Enreg++;
    }
    
    public Document(Document that){
        this(that.getTitre());
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(this.getNumEnreg() < 9)
            builder.append("  ");
        if(this.getNumEnreg() < 99)
            builder.append(" ");
        builder.append(this.getNumEnreg());
        builder.append(" - ");
        builder.append("[Document]");
        builder.append(" - ");
        builder.append(this.titre);
        builder.append("\n");
        
        return builder.toString();
    }

    /**
     *
     * @return
     *      Le numéro d'enregistrement (référence) du document (entier)
     */
    public int getNumEnreg() {
        return numEnreg;
    }

    /**
     *
     * @param numEnreg
     *      Le numéro d'enregistrement (référence) du document (entier)
     */
    public void setNumEnreg(int numEnreg) {
        this.numEnreg = numEnreg;
    }

    /**
     *
     * @return
     *  Le titre du document (String).
     */
    public String getTitre() {
        return titre;
    }

    /**
     *
     * @param titre
     *      Le titre du document (String).
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    @Override
    public Document clone() throws CloneNotSupportedException{
        Document document = (Document) super.clone();
        
        if(this instanceof Livre){
            document = (Livre) super.clone();
        }
        else if(this instanceof Roman){
            document = (Roman) super.clone();
        }
        else if(this instanceof Manuel){
            document = (Manuel) super.clone();
        }
        else if(this instanceof Revue){
            document = (Revue) super.clone();
        }
        document.titre = titre;
        return (Document) document;
        
        /*if(this instanceof Livre){
            return (Livre) super.clone();
        }
        else if(this instanceof Roman){
            return (Roman) super.clone();
        }
        else if(this instanceof Manuel){
            return (Manuel) super.clone();
        }
        else if(this instanceof Revue){
            return (Revue) super.clone();
        }*/
    }
}

