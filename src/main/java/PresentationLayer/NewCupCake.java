package PresentationLayer;

import FunctionLayer.Bottom;
import FunctionLayer.CupCake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;
import UtilHelpers.Quantity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

public class NewCupCake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        Bottom bottom = (Bottom) request.getAttribute("bottom");
        Topping topping = (Topping) request.getAttribute("topping");
        int quantity = (int) request.getAttribute("quantity");

        CupCake cupCake = new CupCake(bottom, topping, quantity);


        if (((Set<CupCake>)session.getAttribute("basket")) == null) {

            Set<CupCake> basket = new HashSet<>();
            session.setAttribute("basket", basket);
        }
        ((Set<CupCake>) session.getAttribute("basket")).add(cupCake);


        return "basket" ;
    }
}
