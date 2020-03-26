package FunctionLayer;

import DB.ToppingMapper;
import UtilHelpers.Quantity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Fårmålet med denne klasser er at kunne generere en cupcake, en cupcake tilsvarer en ordrelinje i DB. Der er lavet getters
 *& setters for de ulike atributer i klassen slik at de nås udenfra.
 * @author MMP
 * @version 1.0
 */


public class CupCake  {


    int orderline_id;
    Bottom bottom;
    Topping topping;
    int quantity;
    int sum;

    public int getOrderline_id() {
        return orderline_id;
    }

    public void setOrderline_id(int orderline_id) {
        this.orderline_id = orderline_id;
    }


    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public CupCake(Bottom bottom, Topping topping, int quantity) {
        this.orderline_id = orderline_id;
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
