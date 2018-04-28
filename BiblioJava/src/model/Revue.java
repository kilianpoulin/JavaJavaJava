package model;

/**
 *  Cette classe contient tous les élements caractérisant une Revue, y compris son affichage.
 *  Sa classe mère est DOCUMENT.
 * @author Kilian
 */
public class Revue extends Document {

    private int mois;
    private int annee;

    /**
     *  Constructeur permettant de créer une revue
     * @param titre
     * @param mois
     *      Mois de parution (entier)
     * @param annee
     *      Année de parution (entier)
     */
    public Revue(String titre, int mois, int annee){
        this.setTitre(titre);
        this.mois = mois;
        this.annee = annee;
    }
    
    public Revue(Revue that){
        this(that.getTitre(), that.getMois(), that.getAnnee());
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(this.getNumEnreg() < 9)
            builder.append("  ");
        if(this.getNumEnreg() < 99)
            builder.append(" ");
        builder.append(this.getNumEnreg());
        builder.append("    [Revue]");
        builder.append("      ");
        builder.append('"');
        builder.append(' ');
        builder.append(this.getTitre());
        builder.append(' ');
        builder.append('"');
        builder.append(",   ");
        builder.append(this.mois);
        builder.append("/");
        builder.append(this.annee);
        builder.append("\n");
        
        return builder.toString();
    }

    /**
     *
     * @return
     *      L'année de parution sous forme d'entier
     */
    public int getAnnee() {
        return annee;
    }

    /**
     *      Setter de l'année de parution (entier)
     * @param annee
     *      Année sous forme d'entier (ex : 2018)
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     *
     * @return
     *      Le mois de parution sous forme d'entier
     */
    public int getMois() {
        return mois;
    }

    /**
     *  Setter du mois de parution (entier)
     * @param mois
     *      Mois sous forme d'entier (ex: 9).
     */
    public void setMois(int mois) {
        this.mois = mois;
    }
	
    @Override
    public Revue clone() throws CloneNotSupportedException{
        Revue revue = (Revue) super.clone();
        setTitre(revue.getTitre());
        mois = revue.mois;
        annee = revue.annee;
        return revue;
    }
        
}
