package model;

// TO DO ...

/**
 *
 * @author Kilian
 */
public class Roman extends Livre {

    private Roman prixLitteraire = null;

    /**
     *
     */
    public static Roman GONCOURT = new Roman();

    /**
     *
     */
    public static Roman MEDICIS = new Roman();

    /**
     *
     */
    public static Roman RENAUDOT = new Roman();
    
    /**
     * Constructeur pour créer un roman vide
    */
    public Roman(){
        
    }
    /**
     * Constructeur d'un roman n'ayant pas reçu de prix littéraire
     * @param titre
     * @param nbPages
     * @param auteur
    */
    public Roman(String titre, String auteur, int nbPages){
        super(titre, auteur, nbPages);
    }
    
    /**
     * Constructeur d'un roman ayant reçu un prix littéraire
     * @param titre
     * @param auteur
     * @param nbPages
     * @param prixLitt
    */
    public Roman(String titre, String auteur, int nbPages, Roman prixLitt){
        super(titre, auteur, nbPages);
        prixLitteraire = prixLitt;
    }

    /**
     *
     * @return
     */
    public Roman getPrixLitteraire() {
        return prixLitteraire;
    }
    
    /**
     *
     * @return
     */
    public String getPrixLitt(){
        if(this.prixLitteraire == GONCOURT)
            return "GONCOURT";
        else if(this.prixLitteraire == MEDICIS)
            return "MEDICIS";
        else if(this.prixLitteraire == RENAUDOT)
            return "RENAUDOT";
        else
            return "";
    }

    /**
     *
     * @param prixLitteraire
     */
    public void setPrixLitteraire(Roman prixLitteraire) {
        this.prixLitteraire = prixLitteraire;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(this.getNumEnreg() < 9)
            builder.append(" ");
        if(this.getNumEnreg() < 99)
            builder.append(" ");
        builder.append(this.getNumEnreg());
        builder.append("   [Roman]");
        builder.append("      ");
        builder.append('"');
        builder.append(' ');
        builder.append(this.getTitre());
        builder.append(' ');
        builder.append('"');
        builder.append(",   ");
        builder.append(this.getAuteur());
        builder.append("    (");
        builder.append(this.getNbPages());
        builder.append(" pages)");
        if(this.prixLitteraire != null){
            builder.append("     ==> a reçu le ");
            builder.append("Prix ");
            builder.append(this.getPrixLitt());
        }
        builder.append("\n");
        return builder.toString();
    }
	
        
}
