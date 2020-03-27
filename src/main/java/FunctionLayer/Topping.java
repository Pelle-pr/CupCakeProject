package FunctionLayer;
/**
 * Formålet med denne klasse er at kunne generere de ulike cupcake-topper kunden kan velge mellom. Der er lavet getters
 * & setters for de ulike atributer i klassen slik at de nås udenfra.
 */

public class Topping {

    private int id;
    private String name;
    private int price;

    public Topping(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public Topping(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
