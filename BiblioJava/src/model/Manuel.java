package model;

// TO DO ...
public class Manuel extends Livre {

    private int niveau;

    public Manuel(String titre, String auteur, int niveau, int nbPages){
        this.setTitre(titre);
        this.setAuteur(auteur);
        this.setNbPages(nbPages);
        this.niveau = niveau;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(this.getNumEnreg() < 9)
            builder.append("  ");
        if(this.getNumEnreg() < 99)
            builder.append(" ");
        builder.append(this.getNumEnreg());
        builder.append("   [Manuel]");
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
        builder.append(" pages)    Niveau ");
        builder.append(this.niveau);
        builder.append("\n");
        
        return builder.toString();
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
        
       

}
