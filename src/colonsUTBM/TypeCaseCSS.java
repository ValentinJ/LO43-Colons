package colonsUTBM;

/**
 * Created by val on 28/11/14.
 */
public enum TypeCaseCSS {

    BIERE("caseBiere, case"),CAFE("caseCafe, case"),COURS("caseCours, case"), NOURRITURE("caseNourriture, case"),
    SOMMEIL("caseSommeil, case"), SEVENANS("caseDesert, case"), OCEAN("caseOcean, case"),
    COMMERCETOUT("caseCommerceTout, case"), COMMERCEBIERE("caseCommerceBiere, case"),
    COMMERCECAFE("caseCommerceCafe, case"), COMMERCECOURS("caseCommerceCours, case"),
    COMMERCENOURRITURE("caseCommerceNourriture, case"), COMMERCESOMMEIL("caseCommerceSommeil, case"),
    BIEREGLANDEUR("caseBiereGlandeur, case"),CAFEGLANDEUR("caseCafeGlandeur, case"),
    COURSGLANDEUR("caseCoursGlandeur, case"), NOURRITUREGLANDEUR("caseNourritureGlandeur, case"),
    SOMMEILGLANDEUR("caseSommeilGlandeur, case"), SEVENANSGLANDEUR("caseDesertGlandeur, case");

    private String name = "";

    TypeCaseCSS(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
