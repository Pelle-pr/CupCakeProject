package DB;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import sun.rmi.runtime.Log;

import java.sql.*;
import java.util.ArrayList;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        Connection con = Connector.connection();
        String SQL = "INSERT INTO user (email, password, role, saldo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS))
        {
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.setInt(4, user.getSaldo());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch (SQLException ex) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login(String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT user_id, role, saldo FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "user_id" );
                int saldo = rs.getInt("saldo");
                User user = new User( email, password, role, saldo);
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch (SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    public static void opdaterSaldo(int user_id, int newSaldo) throws LoginSampleException {
        int result = 0;
        int newId = 0;
        String sql = "update cupcake.user set saldo = ? where user_id = ?";
        try{
        Connection con = Connector.connection();
        PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,newSaldo);
            ps.setInt(2,user_id);
            result = ps.executeUpdate();
        }

        catch (SQLException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();

        }
        if (result == 1){
            System.out.println("Saldo opdateret");

        }
        }

    public static ArrayList<User> GetAllUsers() {

        ArrayList<User> userArrayList = new ArrayList<>();

        String sql = "select * from cupcake.user";
        try (Connection con = Connector.connection();
             PreparedStatement ps = con.prepareStatement(sql))  {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                int user_id = resultSet.getInt("user_id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                int saldo = resultSet.getInt("saldo");


                userArrayList.add(new User(user_id,email,password,role,saldo));
            }
        } catch (SQLException | LoginSampleException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();
        }
        return userArrayList;
    }

    public static void insertMoney (int user_id, int money) throws LoginSampleException {
        int result = 0;
        int newId = 0;
        String sql = "update cupcake.user set saldo = saldo + ? where user_id = ?";
        try{
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,money);
            ps.setInt(2,user_id);
            result = ps.executeUpdate();
        }

        catch (SQLException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();

        }
    }
}


