package FunctionLayer;

public class MyOrderList {

    int order_id;
    int customer_id;
    String date;
    int quantity;
    int sum;
    String bottom_name;
    String topping_name;

    public MyOrderList(int customer_id, int order_id, String date, int quantity, int sum, String bottom_name, String topping_name) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.date = date;
        this.quantity = quantity;
        this.sum = sum;
        this.bottom_name = bottom_name;
        this.topping_name = topping_name;
    }

    public MyOrderList(int order_id, String date, int quantity, int sum, String bottom_name, String topping_name) {
        this.order_id = order_id;
        this.date = date;
        this.quantity = quantity;
        this.sum = sum;
        this.bottom_name = bottom_name;
        this.topping_name = topping_name;
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
