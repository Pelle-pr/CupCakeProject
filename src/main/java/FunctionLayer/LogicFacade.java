package FunctionLayer;

import DB.BottomMapper;
import DB.OrderMapper;
import DB.ToppingMapper;
import DB.UserMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Formålet med LogicFacaden er at gi tilgang til de ulike metoder der ligger i DB, ved at la disse metoder gå innom
 * logicfacaden setter man opp en facade mellom "presentaitionlayer" og DB. Fortrinnsvis skulle
 * alle metoder der ikke ligger i presentationlayer legges innom logicfacaden.
 */
public class LogicFacade {

    public static User login(String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser(String email, String password) throws LoginSampleException, SQLException {
        User user = new User(email, password, "customer", 500);
        UserMapper.createUser( user );
        return user;
    }
    public static ArrayList<Bottom> getAllBottoms() throws LoginSampleException, SQLException {
        return BottomMapper.getAllBottoms();
    }

    public static ArrayList<Topping> getAllToppings() throws LoginSampleException, SQLException {
        return ToppingMapper.getAllToppings();
    }
    public static ArrayList<User> getAllUsers() throws LoginSampleException, SQLException {
        return UserMapper.GetAllUsers();
    }

    public static List<MyOrderList> getAllOrders() throws LoginSampleException, SQLException {
        return OrderMapper.getAllOrders();
    }

    public static void insertMoney(int user_id, int money) throws LoginSampleException, SQLException {
        UserMapper.insertMoney(user_id, money);
    }

    public static void completeOrder(int order_id) throws LoginSampleException, SQLException {
        OrderMapper.completeOrder(order_id);
    }

    public static void transaction (int user_id, Basket basket) throws LoginSampleException, SQLException {
        OrderMapper.transaction(user_id, basket);
    }

}
