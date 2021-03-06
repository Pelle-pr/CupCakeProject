package DB;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import sun.rmi.runtime.Log;

import java.sql.*;
import java.util.ArrayList;

/**
 * Formålet er at udføre CRUD-operationer i user-tabellen i DB
 @author kasper (createUser + login)
 @author MMP (opdaterSaldo, insertMoney + GetAllUsers)
 */

public class UserMapper {

    /**
     * Indsætter en ny bruger i databasen efter registrering
     * @param user
     * @throws LoginSampleException
     */

    public static void createUser( User user ) throws LoginSampleException, SQLException {
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
            throw new LoginSampleException("Der findes allerede en bruger med den email");
        }
    }

    /**
     * Via login hentes/indlæses specifik bruger fra databasen
     * @param email
     * @param password
     * @return Hvis login er succesfuldt returneres user
     * @throws LoginSampleException
     */

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

        /**
         * Opdaterer brugerens saldo efter et køb er gennemført
         */

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

    /**
     * Henter alle users fra DB ned i en arraylist
     * @return Returnerer en arraylist med users
     * @throws LoginSampleException
     */

    public static ArrayList<User> GetAllUsers() throws LoginSampleException, SQLException {

        ArrayList<User> userArrayList = new ArrayList<>();

        String sql = "select * from user";
        Connection con = Connector.connection();
        try {
            PreparedStatement ps = con.prepareStatement(sql) ;
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                int user_id = resultSet.getInt("user_id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                int saldo = resultSet.getInt("saldo");


                userArrayList.add(new User(user_id,email,password,role,saldo));
            }
        } catch (SQLException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();
        }

        return userArrayList;
    }

    /**
     * Opdaterer en saldo med X antal kr. (input fra admin)
     * @param user_id
     * @param money
     * @throws LoginSampleException
     */

    public static void insertMoney (int user_id, int money) throws LoginSampleException, SQLException {
        int result = 0;
        int newId = 0;
        String sql = "update user set saldo = saldo + ? where user_id = ?";

        Connection con = Connector.connection();
        try {
             PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,money);
            ps.setInt(2,user_id);
            ps.executeUpdate();

        }

        catch (SQLException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();

        }
    }
}


