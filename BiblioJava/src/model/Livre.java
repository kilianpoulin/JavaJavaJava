package model;

// TO DO ...

/**
 *  Cette classe contient tous les élements caractérisant un Livre, y compris son affichage.
 *  Sa classe mère est DOCUMENT.
 *  Elle a deux sous-classes (ROMAN et MANUEL)
 * @author Kilian
 */
public class Livre extends Document implements InterfaceAuteur {

    private String auteur;
    private int nbPages;

    /**
     *  Constructeur pour créer un Livre vide
     */
    public Livre(){

    }

    /**
     *  Constructeur pour créer un livre avec tous ses paramètres
     * @param titre
     * @param auteur
     * @param nbPages
     */
    public Livre(String titre, String auteur, int nbPages){
        super(titre);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(this.getNumEnreg() < 9)
            builder.append("  ");
        if(this.getNumEnreg() < 99)
            builder.append(" ");
        builder.append(this.getNumEnreg());
        builder.append("      [Livre]");
        builder.append("      ");
        builder.append('"');
        builder.append(' ');
        builder.append(this.getTitre());
        builder.append(' ');
        builder.append('"');
        builder.append(",   ");
        builder.append(this.auteur);
        builder.append("    (");
        builder.append(this.nbPages);
        builder.append(" pages)");
        builder.append("\n");
        
        return builder.toString();
    }

    /**
     *  
     * @return
     *      Auteur (String)
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     *
     * @param auteur
     *       Auteur (String)
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     *
     * @return
     *       Le nombre de pages du livre (entier)
     */
    public int getNbPages() {
        return nbPages;
    }

    /**
     *
     * @param nbPages
     *       Le nombre de pages du livre (entier)
     */
    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }
        
}
