package model;

/**
 *  Cette classe contient tous les élements caractérisant un Roman, y compris son affichage.
 *  Sa classe mère est LIVRE.
 * @author Kilian
 */
public class Roman extends Livre {

    private String prixLitteraire = null;

    /**
     *  Variable désignant le prix GONCOURT.
     */
    public static String GONCOURT = "GONCOURT";

    /**
     * Variable désignant le prix MEDICIS.
     */
    public static String MEDICIS = "MEDICIS";

    /**
     * Variable désignant le prix RENAUDOT.
     */
    public static String RENAUDOT = "RENAUDOT";
    
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
    public Roman(String titre, String auteur, int nbPages, String prixLitt){
        super(titre, auteur, nbPages);
        prixLitteraire = prixLitt;
    }
    
    public Roman(Roman that){
        this(that.getTitre(), that.getAuteur(), that.getNbPages(), that.getPrixLitteraire());
    }

    /**
     *  Getter du prix littéraire (correspond à une variable static de type Roman).
     * @return
     */
    public String getPrixLitteraire() {
        return prixLitteraire;
    }

    /**
     *  Setter du prix littéraire.
     * @param prixLitteraire
     *      De type roman (correspond à une variable static)
     */
    public void setPrixLitteraire(String prixLitteraire) {
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
            builder.append(this.getPrixLitteraire());
        }
        builder.append("\n");
        return builder.toString();
    }
	
    @Override
    public Roman clone() throws CloneNotSupportedException{
        Roman roman = (Roman) super.clone();
        setTitre(roman.getTitre());
        setAuteur(roman.getAuteur());
        setNbPages(roman.getNbPages()); 
        setPrixLitteraire(roman.getPrixLitteraire());
        return roman;
    }
        
}
