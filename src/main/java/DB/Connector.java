package DB;

import FunctionLayer.LoginSampleException;
import sun.rmi.runtime.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Sørger for at skabe forbindelse til DB
 */

public class Connector {
    private static  String URL;
    private static  String USERNAME;
    private static  String PASSWORD;

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws LoginSampleException, SQLException {
        if ((singleton == null) || singleton.isClosed()) {

            try {
                setDBCredentials();
                Class.forName("com.mysql.cj.jdbc.Driver");
                singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
                throw new LoginSampleException("Problem med at skabe forbindelse til databasen");
            }
        }
        return singleton;
    }

    /**
     * Sætter DB credentials alt efter om det er localhost eller deploy-versionen
     */

    public static void setDBCredentials() {
        String deployed = System.getenv("DEPLOYED");

        if (deployed != null){
            //Prod
            URL = System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
        } else {
            //LocalHost

        URL = "jdbc:mysql://localhost:3306/cupcake?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        USERNAME = "root";
        PASSWORD = "root";
    }

    }

}