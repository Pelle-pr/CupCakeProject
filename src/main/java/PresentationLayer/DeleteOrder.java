package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ServletException, IOException {

        HttpSession session = request.getSession();

        int order_id = Integer.parseInt( request.getParameter("delete"));

        LogicFacade.deleteOrder(order_id);

        session.setAttribute("allOrdersList", LogicFacade.getAllOrders());
        return "orderpage";
    }
}
