package DB;

import FunctionLayer.LoginSampleException;

import java.sql.*;

/**
 * Formålet er at udføre CRUD-operationer i orderline-tabellen i DB
 * @author MMP
 * @version 1.0
 */

public class OrderLineMapper {

    /**
     * Indsætter ordreline(s) i databasen
     * @param orderId
     * @param quantity
     * @param sum
     * @param bottomId
     * @param toppingId
     * @return Orderline ID
     */

    public static  int insertOrderLine (int orderId, int quantity, int sum, int bottomId, int toppingId) {

        int result = 0;
        int orderLineId = 0;
        String sql = "INSERT INTO orderline (order_id, quantity, sum, bottom_id, topping_id) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, orderId);
            ps.setInt(2, quantity);
            ps.setInt(3, sum);
            ps.setInt(4, bottomId);
            ps.setInt(5, toppingId);
            result = ps.executeUpdate();
            ResultSet idResultSet = ps.getGeneratedKeys();
            if (idResultSet.next()) {
                orderLineId = idResultSet.getInt(1);
            }

        } catch (SQLException | LoginSampleException e) {
            System.out.println("Feil i connection til database!");
            e.printStackTrace();
        }

        return orderLineId;
    }
}
