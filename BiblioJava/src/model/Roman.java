package model;

/**
 *  Cette classe contient tous les élements caractérisant un Roman, y compris son affichage.
 *  Sa classe mère est LIVRE.
 * @author Kilian
 */
public class Roman extends Livre {

    private Roman prixLitteraire = null;

    /**
     *  Variable désignant le prix GONCOURT.
     */
    public static Roman GONCOURT = new Roman();

    /**
     * Variable désignant le prix MEDICIS.
     */
    public static Roman MEDICIS = new Roman();

    /**
     * Variable désignant le prix RENAUDOT.
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
     *      Prix littéraire reçu (est de type Roman, correspond à une variable static).
    */
    public Roman(String titre, String auteur, int nbPages, Roman prixLitt){
        super(titre, auteur, nbPages);
        prixLitteraire = prixLitt;
    }

    /**
     *  Getter du prix littéraire (correspond à une variable static de type Roman).
     * @return
     */
    public Roman getPrixLitteraire() {
        return prixLitteraire;
    }
    
    /**
     *  Affichage du prix Littéraire non plus comme un élément de type Roman mais comme un String.
     * @return
     *      une chaine de caractère (vide si le roman n'a pas reçu de prix littéraire).
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
     *  Setter du prix littéraire.
     * @param prixLitteraire
     *      De type roman (correspond à une variable static)
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
