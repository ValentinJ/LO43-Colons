package colonsUTBM;

/**
 * Created by Guillaume on 02/12/2014.
 */
public abstract class Carte {
    protected String description;
    protected String nom;
    protected String img;

    public Carte(){}

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
