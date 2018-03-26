package model;

// TO DO ...
public abstract class Document {
	
    public static int NB_ENREG = 0;
    private int numEnreg;
    private String titre;

    public Document(){

    }
    
    public Document(String titre){
        this.titre = titre;
        this.numEnreg = NB_ENREG;
        NB_ENREG++;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("Le titre de ce document est ");
        builder.append(this.getTitre());
        
        return builder.toString();
    }

     public int getNumEnreg() {
        return numEnreg;
    }

    public void setNumEnreg(int numEnreg) {
        this.numEnreg = numEnreg;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

        
}
