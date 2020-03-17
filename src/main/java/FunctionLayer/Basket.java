package FunctionLayer;

public class Basket {

    CupCake cupCake;
    int totalSum = 0;

    public Basket(CupCake cupCake) {
        this.cupCake = cupCake;
        this.totalSum = cupCake.getSum() + totalSum;
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
