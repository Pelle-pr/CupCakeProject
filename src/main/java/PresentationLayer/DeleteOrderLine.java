package PresentationLayer;

import FunctionLayer.Basket;
import FunctionLayer.Bottom;
import FunctionLayer.CupCake;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Sletter en ordrelinje fra Brugerens Kurv.
 * Får parameter Order ID.
 */
public class DeleteOrderLine extends Command {



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ServletException, IOException {

        HttpSession session = request.getSession();
        int orderLine_id = Integer.parseInt(request.getParameter("remove")) ;
        Basket basket = (Basket) session.getAttribute("basket");
        basket.removeCupcake(orderLine_id);
        session.setAttribute("basket",basket );
        session.setAttribute("totalSum", basket.getTotalSum());
        return "basket";
    }

}
