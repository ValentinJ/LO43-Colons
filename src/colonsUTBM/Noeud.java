package colonsUTBM;

/**
 * Created by val on 03/12/14.
 */
public abstract class Noeud {
    protected Point pts;
    protected String typeCSS;
    protected String id;

    abstract public String getTypeCSS();

    public Point getPts() {
        return pts;
    }

    public void setPts(Point pts) {
        this.pts = pts;
    }

    public void setTypeCSS(String typeCSS) {
        this.typeCSS = typeCSS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
