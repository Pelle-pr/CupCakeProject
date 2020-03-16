package DB;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ToppingMapper {

    public static ArrayList<Topping> getAllToppings() throws LoginSampleException {

        ArrayList<Topping> toppingList = new ArrayList<>();
        Connection con = Connector.connection();
        String sql = "SELECT * FROM cupcake.topping";
        try (
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                int topping_id = resultSet.getInt("topping_id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Topping newTopping = new Topping(topping_id,name, price);
                toppingList.add(newTopping);
            }
        } catch (SQLException e) {
            System.out.println("Fejl i sqlforespørgsel");
            e.printStackTrace();
        }
        return toppingList;
    }
}
