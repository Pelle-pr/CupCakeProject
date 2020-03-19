package PresentationLayer;

import DB.OrderMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class MyOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ServletException, IOException {

        HttpSession session = request.getSession();


        int user_id = (int) session.getAttribute("user_id");

        session.setAttribute("myorderlist", OrderMapper.myOrdersByID(user_id));




        return "myorders";
    }
}
