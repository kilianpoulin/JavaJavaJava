package model;

// TO DO ...

/**
 *
 * @author Kilian
 */
public class Livre extends Document implements InterfaceAuteur {

    private String auteur;
    private int nbPages;

    /**
     *
     */
    public Livre(){

    }

    /**
     *
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
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     *
     * @param auteur
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     *
     * @return
     */
    public int getNbPages() {
        return nbPages;
    }

    /**
     *
     * @param nbPages
     */
    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }
        
}
