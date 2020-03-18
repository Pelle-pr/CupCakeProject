package FunctionLayer;

import DB.ToppingMapper;
import UtilHelpers.Quantity;


public class CupCake  {

    Bottom bottom;
    Topping topping;
    int quantity;
    int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public CupCake(Bottom bottom, Topping topping, int quantity) {
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
        this.sum = (bottom.getPrice() + topping.getPrice()) * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }


}
