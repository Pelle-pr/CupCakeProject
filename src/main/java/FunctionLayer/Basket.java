package FunctionLayer;

public class Basket {

    CupCake cupCake;
    int totalSum;

    public Basket(CupCake cupCake) {
        this.cupCake = cupCake;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public CupCake getCupCake() {
        return cupCake;
    }

    public void setCupCake(CupCake cupCake) {
        this.cupCake = cupCake;
    }
}
