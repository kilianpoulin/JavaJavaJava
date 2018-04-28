package model;

// TO DO ...

/**
 *  Cette classe contient tous les élements caractérisant un Manuel, y compris son affichage.
 *  Sa classe mère est LIVRE.
 * @author Kilian
 */
public class Manuel extends Livre {

    private int niveau;

    /**
     *
     * @param titre
     * @param auteur
     * @param niveau
     *      Niveau du manuel sous forme d'entier
     * @param nbPages
     */
    public Manuel(String titre, String auteur, int niveau, int nbPages){
        this.setTitre(titre);
        this.setAuteur(auteur);
        this.setNbPages(nbPages);
        this.niveau = niveau;
    }
    
    public Manuel(Manuel that){
        this(that.getTitre(), that.getAuteur(), that.getNiveau(), that.getNbPages());
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

    /**
     *  Récupère le niveau sous forme d'entier
     * @return
     *       niveau sous forme d'entier (ex : 2)
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     *  Setter du niveau (entier)
     * @param niveau
     *      Entier (ex : 2).
     */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    } 
    
    public Manuel clone() throws CloneNotSupportedException{
        Manuel manuel = (Manuel) super.clone();
        setTitre(manuel.getTitre());
        setAuteur(manuel.getAuteur());
        setNbPages(manuel.getNbPages());
        niveau = manuel.niveau;
        return manuel;
    }
}
