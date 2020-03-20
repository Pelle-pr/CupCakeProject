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

public class DeleteOrderLine extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ServletException, IOException {

        HttpSession session = request.getSession();
        int orderLine_id = (int) session.getAttribute("remove");

        Set<Basket> basketSet = (Set<Basket>) session.getAttribute("basket");

        basketSet.remove( findOrderline(orderLine_id, basketSet));

        session.setAttribute("basket",basketSet );

        return "basket.jsp";
    }

    private CupCake findOrderline(int orderLine_id, Set<Basket> basketSet) {

        for (Basket basket : basketSet) {
            if (basket.getCupCake().getOrderline_id() == orderLine_id) {
                return basket.getCupCake();
            }

        }

        return null;


    }
}
