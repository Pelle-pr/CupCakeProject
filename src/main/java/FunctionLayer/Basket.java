package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    CupCake cupCake;

    private List<CupCake> cupCakeList = null;
    private int count = 0;
    int totalSum;

    public Basket(CupCake cupCake) {
        if (cupCakeList == null){
            cupCakeList = new ArrayList<>();
        }

        this.count++;
        cupCake.setOrderline_id(count);
        this.cupCakeList.add(cupCake);
        //this.totalSum += cupCake.getSum();
    }

    public void addCupcake(CupCake cupCake){
        this.count++;
        cupCake.setOrderline_id(count);
        this.cupCakeList.add(cupCake);
    }

    public int getTotalSum(){
        int sum = 0;
        for (CupCake cake : cupCakeList) {
            sum += cake.getSum();
        }
        return sum;
    }

    public CupCake getCupCakeById(int id){
        for (CupCake cake : cupCakeList) {
            if (cake.getOrderline_id() == id) {
                return cake;
            }
        }
        return null;
    }

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
