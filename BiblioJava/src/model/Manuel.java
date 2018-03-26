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
        builder.append("\n");
        builder.append("Ce manuel de titre ");
        builder.append(this.getTitre());
        builder.append(" a été écrit par ");
        builder.append(this.getAuteur());
        builder.append("\n");
        builder.append("Il est destiné au niveau");
        builder.append(this.niveau);
        builder.append(". \n");
        builder.append("Il comporte ");
        builder.append(this.getNbPages());
        builder.append(" pages.");
        
        return builder.toString();
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
        
       

}
