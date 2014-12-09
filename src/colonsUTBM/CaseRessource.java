package colonsUTBM;

/**
 * Created by Guillaume on 03/12/2014.
 */
public class CaseRessource extends Case{
    private TypeCase typeCase;
    protected int valeur;
    protected boolean binomeGlandeur;

    public boolean isBinomeGlandeur() {
        return false;
    }

    public void setBinomeGlandeur(boolean b) {
        binomeGlandeur = b;
    }

    public int getValeurNumerique() {
        return 0;
    }

    public TypeCase getTypeCase() {
        return null;
    }
}
