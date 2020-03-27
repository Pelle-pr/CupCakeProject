package FunctionLayer;

/**
 * Formålet til denne klasse er at generere en liste over de ordre en kunde har foretatt seg, der er lavet getters
 * & setters for de ulike atributer i klassen slik at de nås udenfra.
 */

public class MyOrderList {

    private int order_id;
    private int customer_id;
    private String date;
    private int quantity;
    private int sum;
    private String bottom_name;
    private String topping_name;
    private String status;

    public MyOrderList(int customer_id, int order_id, String date, int quantity, int sum, String bottom_name, String topping_name, String status) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.date = date;
        this.quantity = quantity;
        this.sum = sum;
        this.bottom_name = bottom_name;
        this.topping_name = topping_name;
        this.status = status;
    }

    public MyOrderList(int order_id, String date, int quantity, int sum, String bottom_name, String topping_name, String status) {
        this.order_id = order_id;
        this.date = date;
        this.quantity = quantity;
        this.sum = sum;
        this.bottom_name = bottom_name;
        this.topping_name = topping_name;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getBottom_name() {
        return bottom_name;
    }

    public void setBottom_name(String bottom_name) {
        this.bottom_name = bottom_name;
    }

    public String getTopping_name() {
        return topping_name;
    }

    public void setTopping_name(String topping_name) {
        this.topping_name = topping_name;
    }
}
