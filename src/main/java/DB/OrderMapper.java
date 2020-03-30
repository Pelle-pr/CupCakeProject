package DB;

import FunctionLayer.*;
import PresentationLayer.MyOrder;


import java.sql.*;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Formålet er at udføre CRUD-operationer i order-tabellen i DB
 * @author MMP
 * @version 1.0
 */

public class OrderMapper {

    /**
     * Indsætter ordre i databasen
     * @param userId
     * @param date
     * @return Order ID
     */

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

    /**
     * Klarer både at indsætte orderline(s) og ordre i databasen vha. SQL-transaction
     * @param userId
     * @param basket
     * @throws SQLException
     * @throws LoginSampleException
     */

    public static int transaction(int userId, Basket basket) throws SQLException, LoginSampleException {

        LocalDate date = LocalDate.now();
        int order_id = 0;
        String sqlOrder = "INSERT INTO cupcake.order (user_id, date, status) VALUES (?, ?, ?)";
        String sqlOrderLine = "INSERT INTO cupcake.orderline (order_id, quantity, sum, bottom_id, topping_id) VALUES (?, ?, ?, ?, ?)";

        try  {
            Connection con = Connector.connection();
            con.setAutoCommit(false);
            try (PreparedStatement ps = con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, userId);
                ps.setDate(2, Date.valueOf(date));
                ps.setString(3, "Processing");
                ps.executeUpdate();

                ResultSet idResultSet = ps.getGeneratedKeys();

                if (idResultSet.next()) {
                    order_id = idResultSet.getInt(1);
                }

                for (CupCake cake: basket.getCupCakeList()) {
                    try (PreparedStatement ps1 = con.prepareStatement(sqlOrderLine, Statement.RETURN_GENERATED_KEYS)) {
                        ps1.setInt(1, order_id);
                        ps1.setInt(2, cake.getQuantity());
                        ps1.setInt(3,cake.getSum());
                        ps1.setInt(4,cake.getBottom().getId());
                        ps1.setInt(5,cake.getTopping().getId());
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

    /**
     * Indhenter orderliste, lavet vha. inner joins, fra databasen på ID-basis, fx for bruger med user ID nr. 5
     * @param user_id
     * @return En arrayliste med ordre (på det specifikke user ID)
     * @throws LoginSampleException
     * @throws SQLException
     */

    public static List<MyOrderList> myOrdersByID (int user_id) throws LoginSampleException, SQLException {

        List<MyOrderList> orderlist = new ArrayList<>();
        String sqlOrders = "SELECT o.status, o.order_id, o.date, ol.quantity, ol.sum, b.name, t.name\n" +
                "from cupcake.order o\n" +
                "inner join cupcake.orderline ol on o.order_id = ol.order_id\n" +
                "inner join cupcake.bottom b on ol.bottom_id = b.bottom_id\n" +
                "inner join cupcake.topping t on ol.topping_id = t.topping_id\n" +
                "where user_id = "+ user_id + " order by order_id desc";
        Connection con = Connector.connection();
        try  (  PreparedStatement ps = con.prepareStatement(sqlOrders);
                ResultSet resultSet = ps.executeQuery() )
        {
            while (resultSet.next()) {
                int order_id = resultSet.getInt("order_id");
                String date = resultSet.getString("date");
                int quantity = resultSet.getInt("quantity");
                int sum = resultSet.getInt("sum");
                String bottom_name = resultSet.getString("name");
                String topping_name = resultSet.getString("name");
                String status = resultSet.getString("status");


                MyOrderList myOrderList  = new MyOrderList(order_id,date,quantity,sum,bottom_name,topping_name,status);
                orderlist.add(myOrderList);
            }
        } catch (SQLException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();
        }
        return orderlist;
    }

    /**
     * Henter alle orders fra DB ned i en arraylist
     * @return Returnerer arraylist med orders
     * @throws LoginSampleException
     * @throws SQLException
     */

    public static List<MyOrderList> getAllOrders() throws LoginSampleException, SQLException {

        List<MyOrderList> orderlist = new ArrayList<>();
        String sqlOrders = "SELECT o.status, o.user_id, o.order_id, o.date, ol.quantity, ol.sum, b.name, t.name\n" +
                "from cupcake.order o\n" +
                "inner join cupcake.orderline ol on o.order_id = ol.order_id\n" +
                "inner join cupcake.bottom b on ol.bottom_id = b.bottom_id\n" +
                "inner join cupcake.topping t on ol.topping_id = t.topping_id\n" +
                "order by order_id desc";
        Connection con = Connector.connection();
        try  (  PreparedStatement ps = con.prepareStatement(sqlOrders);
                ResultSet resultSet = ps.executeQuery() )
        {
            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                int order_id = resultSet.getInt("order_id");
                String date = resultSet.getString("date");
                int quantity = resultSet.getInt("quantity");
                int sum = resultSet.getInt("sum");
                String bottom_name = resultSet.getString("name");
                String topping_name = resultSet.getString("name");
                String status = resultSet.getString("status");


                MyOrderList myOrderList  = new MyOrderList(user_id,order_id,date,quantity,sum,bottom_name,topping_name,status);
                orderlist.add(myOrderList);
            }
        } catch (SQLException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();
        }
        return orderlist;
    }

    /**
     * Opdaterer status på en ordre fra at stå som 'processing' til 'completed'
     * @param order_id
     * @throws LoginSampleException
     */

    public static void completeOrder(int order_id) throws LoginSampleException, SQLException {

        String sql = "UPDATE cupcake.order SET status = 'Completed' WHERE order_id = ?";
        Connection con = Connector.connection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();
        }
    }
}

