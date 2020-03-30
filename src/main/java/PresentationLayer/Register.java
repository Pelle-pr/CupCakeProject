package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import UtilHelpers.Quantity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Command til at registere en ny bruger
 * Får parametrene Email og Kodeord fra Useren på frontend
 */

public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(email, password1);
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
            session.setAttribute("email", email);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("user_id", user.getId());
            session.setAttribute("saldo", user.getSaldo());
            return user.getRole() + "page";
        } else {
            throw new LoginSampleException("the two passwords did not match");
        }
    }

}
