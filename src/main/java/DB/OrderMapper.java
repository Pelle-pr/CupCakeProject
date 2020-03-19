package DB;

import FunctionLayer.Basket;
import FunctionLayer.LoginSampleException;


import java.sql.*;
import java.time.LocalDate;

import java.util.Set;


public class OrderMapper {


    public static int insertOrder(int userId, String date) {

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

    public static int transaction(int userId, Set<Basket> basketSet) throws SQLException, LoginSampleException {

        LocalDate date = LocalDate.now();
        int order_id = 0;
        String sqlOrder = "INSERT INTO cupcake.order (user_id, date) VALUES (?, ?)";
        String sqlOrderLine = "INSERT INTO cupcake.orderline (order_id, quantity, sum, bottom_id, topping_id) VALUES (?, ?, ?, ?, ?)";

        try  {
            Connection con = Connector.connection();
            con.setAutoCommit(false);
            try (PreparedStatement ps = con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, userId);
                ps.setDate(2, Date.valueOf(date));
                ps.executeUpdate();

                ResultSet idResultSet = ps.getGeneratedKeys();

                if (idResultSet.next()) {
                    order_id = idResultSet.getInt(1);
                }

                for (Basket basket : basketSet) {
                    try (PreparedStatement ps1 = con.prepareStatement(sqlOrderLine, Statement.RETURN_GENERATED_KEYS)) {
                        ps1.setInt(1, order_id);
                        ps1.setInt(2, basket.getCupCake().getQuantity());
                        ps1.setInt(3, basket.getCupCake().getSum());
                        ps1.setInt(4, basket.getCupCake().getBottom().getId());
                        ps1.setInt(5, basket.getCupCake().getTopping().getId());
                        ps1.executeUpdate();
                    }
                    catch (Exception e){
                        con.rollback();
                    }
                }
                con.commit();
                con.setAutoCommit(true);
                return order_id;
            }


        } catch (Exception e){


        }
        return 0;
    }
}
