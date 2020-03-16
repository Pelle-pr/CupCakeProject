package DB;

import FunctionLayer.Bottom;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BottomMapper {

    public static ArrayList<Bottom> getAllBottoms() throws LoginSampleException {

        ArrayList<Bottom> bottomList = new ArrayList<>();

        String sql = "SELECT name, price FROM cupcake.bottom";
        Connection con = Connector.connection();
        try  (  PreparedStatement ps = con.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery(); )
        {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Bottom newBottom = new Bottom(name, price);
                bottomList.add(newBottom);
            }
        } catch (SQLException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();
        }
        return bottomList;
    }
}
