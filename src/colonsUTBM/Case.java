package colonsUTBM;

import java.util.ArrayList;

/**
 * Created by val on 28/11/14.
 */
public abstract class Case extends Noeud{
    protected TypeCase tc;

    public TypeCase getTc() {
        return tc;
    }

    abstract public ArrayList<Point> getPointsCase();

    abstract public void setTypeCSS();
}
