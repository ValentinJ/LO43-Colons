package colonsUTBM;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Guillaume on 02/12/2014.
 */
public class Des {
    private int v1;
    private int v2;

    public Des(){v1=1; v2=1;}

    public void lancerDes(){
        Random r = new Random();
        v1 = 1 + r.nextInt(6);
        v2 = 1 + r.nextInt(6);
    }

    public int getTotalDes(){
        return v1+v2;
    }

    public String getImgV1(){
        return "dice"+v1+".png";
    }
    public String getImgV2(){
        return "dice"+v2+".png";
    }
}
