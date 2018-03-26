package model;

// TO DO ...
public class Roman extends Livre {

    private int prixLitteraire = 0;
    public static Roman GONCOURT;
    public static Roman MEDICIS;

    public Roman(String titre, String auteur, int nbPages, Roman prixLitt){
        this.setTitre(titre);
        this.setAuteur(auteur);
        this.setNbPages(nbPages);
        this.prixLitteraire++;
    }

    public int getPrixLitteraire() {
        return prixLitteraire;
    }

    public void setPrixLitteraire(int prixLitteraire) {
        this.prixLitteraire = prixLitteraire;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("Ce roman de titre ");
        builder.append(this.getTitre());
        builder.append(" a été écrit par ");
        builder.append(this.getAuteur());
        builder.append("\n");
        builder.append("Il a reçu ");
        builder.append(this.prixLitteraire);
        builder.append(" prix littéraires.");
        builder.append("\n");
        builder.append("Il comporte ");
        builder.append(this.getNbPages());
        builder.append(" pages.");
        
        return builder.toString();
    }
	
        
}
