package FunctionLayer;

import DB.ToppingMapper;
import UtilHelpers.Quantity;


public class CupCake  {

    Bottom bottom;
    Topping topping;
    Quantity quantity;

    public CupCake(Bottom bottom, Topping topping, Quantity quantity) {
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
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
