package DB;

import FunctionLayer.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ToppingMapper {

    public static ArrayList<Topping> getAllToppings() {

        ArrayList<Topping> toppingList = new ArrayList<>();

        String sql = "SELECT name, price FROM cupcake.topping";
        try (Connection con = Connector.connection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Topping newTopping = new Topping(name, price);
                toppingList.add(newTopping);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();
        }
        return toppingList;
    }
}
