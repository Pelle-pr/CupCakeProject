package FunctionLayer;

import DB.UserMapper;

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

}
