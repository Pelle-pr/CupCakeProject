package FunctionLayer;

import DB.ToppingMapper;

public class CupCake {

    Topping topping;
    Bottom bottom;
    int quantity;

    public CupCake(Topping topping, Bottom bottom, int quantity) {
        this.topping = topping;
        this.bottom = bottom;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
