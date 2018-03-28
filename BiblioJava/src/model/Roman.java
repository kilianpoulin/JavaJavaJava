package model;

// TO DO ...
public class Roman extends Livre {

    private Roman prixLitteraire = null;
    public static Roman GONCOURT = new Roman();
    public static Roman MEDICIS = new Roman();
    
    /**
     * Constructeur pour créer un roman vide
    */
    public Roman(){
        
    }
    /**
     * Constructeur d'un roman n'ayant pas reçu de prix littéraire
    */
    public Roman(String titre, String auteur, int nbPages){
        super(titre, auteur, nbPages);
    }
    
    /**
     * Constructeur d'un roman ayant reçu un prix littéraire
    */
    public Roman(String titre, String auteur, int nbPages, Roman prixLitt){
        super(titre, auteur, nbPages);
        prixLitteraire = prixLitt;
    }

    public Roman getPrixLitteraire() {
        return prixLitteraire;
    }
    
    public String getPrixLitt(){
        if(this.prixLitteraire == GONCOURT)
            return "GONCOURT";
        else if(this.prixLitteraire == MEDICIS)
            return "MEDICIS";
        else
            return "";
    }

    public void setPrixLitteraire(Roman prixLitteraire) {
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
        if(null != this.prixLitteraire){
            builder.append("Il a reçu le prix ");
            builder.append(this.getPrixLitt());
        }
        else
            builder.append("Il n'a pas reçu prix littéraires.");
        
        builder.append("\n");
        builder.append("Il comporte ");
        builder.append(this.getNbPages());
        builder.append(" pages.");
        builder.append("\n");
        
        return builder.toString();
    }
	
        
}
