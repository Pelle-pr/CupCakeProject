package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Formålet til denne klasse er at opprette en handlekurv for kunden, hvor de bestilte cupcakes legges til i en arrayliste (cupCakeList),
 * hver cupcake tilsvarer en ordrelinje i DB. Denne klassen inneholder også metoder for å fjerne en cupcake
 * før ordren er gjennomført, samt en metode der opplyser kunden om totalsum for det kunden ønsker å bestille. Der er lavet getters
 * & setters for de ulike atributer i klassen slik at de nås udenfra.
 * @author MMP
 * @version 1.0
 */

public class Basket {

    CupCake cupCake;

    private List<CupCake> cupCakeList = null;
    private int count = 0;
    int totalSum;

    /**
     * Oppretter en arrayliste (cupCakeList) slik at kunden kan legge til cupcakes(ordrelinier) i sin bestilling
     * @param cupCake
     */

    public Basket(CupCake cupCake) {

        if (cupCakeList == null){
            cupCakeList = new ArrayList<>();
        }

        this.count++;
        cupCake.setOrderline_id(count);
        this.cupCakeList.add(cupCake);
        //this.totalSum += cupCake.getSum();
    }

    /**
     * Legger en cupcake(ordrelinie) inn i en arrayliste (cupCakeList)
     * @param cupCake
     */

    public void addCupcake(CupCake cupCake){
        this.count++;
        cupCake.setOrderline_id(count);
        this.cupCakeList.add(cupCake);
    }

    /**
     * Legger sammen summen av alle cupcakes(ordrelinier) i en arrayliste (cupCakeList)
     * @return sum
     */

    public int getTotalSum(){
        int sum = 0;
        for (CupCake cake : cupCakeList) {
            sum += cake.getSum();
        }
        return sum;
    }

    /**
     * Henter en spesifikk cupcake(ordreline) fra en arrayliste (cupCakeList) slik at den kan slettes ved hjelp av medtoden removeCupcake
     * @param id
     * @return
     */
    public CupCake getCupCakeById(int id){
        for (CupCake cake : cupCakeList) {
            if (cake.getOrderline_id() == id) {
                return cake;
            }
        }
        return null;
    }

    /**
     * Sletter en cupcake(ordrelinie) fra en arrayliste (cupCakeList)
     * @param id
     */
    public void removeCupcake(int id){
        CupCake cupcakeToRemove = getCupCakeById(id);
        if (cupcakeToRemove != null){
            cupCakeList.remove(getCupCakeById(id));
            this.count--;
        }
    }

    public CupCake getCupCake() {
        return cupCake;
    }

    public void setCupCake(CupCake cupCake) {
        this.cupCake = cupCake;
    }

    public List<CupCake> getCupCakeList(){
        return this.cupCakeList;
    }
}
