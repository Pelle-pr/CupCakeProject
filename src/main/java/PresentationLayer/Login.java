package PresentationLayer;

import FunctionLayer.*;
import UtilHelpers.Quantity;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Login henter alle Topping, Bottom, og Quantity listerne og ligger på Servletcontext.
 * Redirecter brugeren til Customerpage hvis brugerens rolle er "Customer"
 * Redirecter brugeren til Adminpage hvis brugerens roller er "Admin"

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException, SQLException {

        HttpSession session = request.getSession();

        if (request.getServletContext().getAttribute("bottomlist") == null) {
            request.getServletContext().setAttribute("bottomlist", LogicFacade.getAllBottoms());
        }
        if (request.getServletContext().getAttribute("toppinglist") == null) {
            request.getServletContext().setAttribute("toppinglist", LogicFacade.getAllToppings());
        }
        if (request.getServletContext().getAttribute("quantity") == null) {
            request.getServletContext().setAttribute("quantity", Quantity.getQuantity());
        }

        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login ( email, password );


        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
        session.setAttribute("user_id",user.getId());
        session.setAttribute("saldo",user.getSaldo());



       return user.getRole() + "page";

    }

}
