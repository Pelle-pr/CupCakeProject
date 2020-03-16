package PresentationLayer;

import FunctionLayer.*;
import UtilHelpers.Quantity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewCupCake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

       Bottom bottom = new Bottom(request.getParameter("bottom"));
       Topping topping = new Topping(request.getParameter("topping"));
//       Quantity quantity = new Quantity(Integer.parseInt(request.getParameter("quantity")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
       CupCake cupCake = new CupCake(bottom,topping,quantity);

        Basket basket = new Basket(cupCake);


        if(session.getAttribute("basket")== null){

            Set<Basket> basketSet = new HashSet<>();

            session.setAttribute("basket",basketSet);
        }
        ((Set<Basket>) session.getAttribute("basket")).add(basket);



        return "basket" ;
    }
}