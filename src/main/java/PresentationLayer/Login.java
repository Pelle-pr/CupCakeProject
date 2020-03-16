package PresentationLayer;

import FunctionLayer.*;
import UtilHelpers.Quantity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );

        HttpSession session = request.getSession();

        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
        session.setAttribute("user_id",user.getId());


        List<Bottom> bottomList = new ArrayList<>(DB.BottomMapper.getAllBottoms());
        session.setAttribute("bottomlist", bottomList);

        List<Topping> toppingList = new ArrayList<>(DB.ToppingMapper.getAllToppings());
        session.setAttribute("toppinglist", toppingList);

        session.setAttribute("quantitylist", Quantity.getQuantity());

        return user.getRole() + "page";
    }

}
