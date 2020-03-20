package FunctionLayer;

import DB.BottomMapper;
import DB.OrderMapper;
import DB.ToppingMapper;
import DB.UserMapper;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer", 500);
        UserMapper.createUser( user );
        return user;
    }
    public static ArrayList<Bottom> getAllBottoms() throws LoginSampleException {
        return BottomMapper.getAllBottoms();
    }

    public static ArrayList<Topping> getAllToppings() throws LoginSampleException {
        return ToppingMapper.getAllToppings();
    }




}
