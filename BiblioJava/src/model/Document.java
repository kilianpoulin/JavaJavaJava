package model;

// TO DO ...

/**
 *
 * @author Kilian
 */
public abstract class Document {
	
    /**
     *
     */
    public static int Nb_Enreg = 0;
    private int numEnreg;
    private String titre;

    /**
     *
     */
    public Document(){
        this.numEnreg = Nb_Enreg;
        Nb_Enreg++;
    }
    
    /**
     *
     * @param titre
     */
    public Document(String titre){
        this.titre = titre;
        this.numEnreg = Nb_Enreg;
        Nb_Enreg++;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(this.getNumEnreg() < 9)
            builder.append("  ");
        if(this.getNumEnreg() < 99)
            builder.append(" ");
        builder.append(this.getNumEnreg());
        builder.append(" - ");
        builder.append("[Document]");
        builder.append(" - ");
        builder.append(this.titre);
        builder.append("\n");
        /*
        builder.append("\n");
        builder.append("Le titre de ce document est ");
        builder.append(this.getTitre());
        */
        
        return builder.toString();
    }

    /**
     *
     * @return
     */
    public int getNumEnreg() {
        return numEnreg;
    }

    /**
     *
     * @param numEnreg
     */
    public void setNumEnreg(int numEnreg) {
        this.numEnreg = numEnreg;
    }

    /**
     *
     * @return
     */
    public String getTitre() {
        return titre;
    }

    /**
     *
     * @param titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }
}

