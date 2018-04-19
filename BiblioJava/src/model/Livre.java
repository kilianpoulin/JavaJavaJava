package model;

// TO DO ...
public class Livre extends Document implements InterfaceAuteur {

    private String auteur;
    private int nbPages;

    public Livre(){

    }

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

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }
        
}
