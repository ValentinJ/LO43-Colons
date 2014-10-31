package colons;

import java.util.Random;

/**
 * Created by val on 30/10/14.
 */
public class Des {
    public int valeur;

    public Des() {
        Random rand = new Random();
        int valeur = rand.nextInt(12 - 1 + 1) + 1;
    }
}
