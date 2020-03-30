package DB;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Formålet er at udføre CRUD-operationer i bottom-tabellen i DB
 * @author MMP
 * @version 1.0
 */

public class ToppingMapper {

    /**
     * Henter alle toppings fra DB ned i en arraylist
     * @return Returnerer en arraylist med toppings
     * @throws LoginSampleException
     */

    public static ArrayList<Topping> getAllToppings() throws LoginSampleException, SQLException {

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
