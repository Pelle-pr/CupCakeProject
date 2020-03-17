package DB;

import FunctionLayer.LoginSampleException;

import java.sql.*;

public class OrderMapper {

    public static  int insertOrder (int userId, String date) {

        int result = 0;
        int orderId = 0;
        String sql = "INSERT INTO order (user_id, date) VALUES (?, ?)";

        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setString(2, date);
            result = ps.executeUpdate();
            ResultSet idResultSet = ps.getGeneratedKeys();
            if (idResultSet.next()) {
                orderId = idResultSet.getInt(1);
            }

        } catch (SQLException | LoginSampleException e) {
            System.out.println("Feil i connection til database!");
            e.printStackTrace();
        }

        return orderId;
    }
}
