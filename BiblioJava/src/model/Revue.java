package model;

// TO DO ...
public class Revue extends Document {

    private int mois;
    private int annee;

    public Revue(String titre, int mois, int annee){
        this.setTitre(titre);
        this.mois = mois;
        this.annee = annee;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("Le titre de cette revue est ");
        builder.append(this.getTitre());
        builder.append("\n");
        builder.append("Elle a été publiée en ");
        builder.append(this.mois);
        builder.append("/");
        builder.append(this.annee);
        builder.append(".\n");
        
        return builder.toString();
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }
	
        
}
