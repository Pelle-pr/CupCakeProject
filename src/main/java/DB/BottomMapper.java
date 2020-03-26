package DB;

import FunctionLayer.Bottom;
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

public class BottomMapper {

    /**
     * Henter alle bottoms fra DB ned i en arraylist
     * @return Returnerer en arraylist med bottoms
     * @throws LoginSampleException
     */

    public static ArrayList<Bottom> getAllBottoms() throws LoginSampleException {

        ArrayList<Bottom> bottomList = new ArrayList<>();

        String sql = "SELECT * FROM cupcake.bottom";
        Connection con = Connector.connection();
        try  (  PreparedStatement ps = con.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery() )
        {
            while (resultSet.next()) {
                int bottom_id = resultSet.getInt("bottom_id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Bottom newBottom = new Bottom(bottom_id,name, price);
                bottomList.add(newBottom);
            }
        } catch (SQLException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();
        }
        return bottomList;
    }
}
