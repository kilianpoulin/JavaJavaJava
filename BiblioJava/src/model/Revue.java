package model;

// TO DO ...

/**
 *
 * @author Kilian
 */
public class Revue extends Document {

    private int mois;
    private int annee;

    /**
     *
     * @param titre
     * @param mois
     * @param annee
     */
    public Revue(String titre, int mois, int annee){
        this.setTitre(titre);
        this.mois = mois;
        this.annee = annee;
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
     */
    public int getAnnee() {
        return annee;
    }

    /**
     *
     * @param annee
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     *
     * @return
     */
    public int getMois() {
        return mois;
    }

    /**
     *
     * @param mois
     */
    public void setMois(int mois) {
        this.mois = mois;
    }
	
        
}
