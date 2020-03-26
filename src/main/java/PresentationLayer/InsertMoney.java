package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Indsætter penge på useren saldo, dette er kun Admin der har adgang til dette.
 *
 */
public class InsertMoney extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ServletException, IOException {

        HttpSession session = request.getSession();


        int user_id = Integer.parseInt(request.getParameter("user_saldo")) ;
        int money = Integer.parseInt(request.getParameter("money"));

        LogicFacade.insertMoney(user_id, money);
        session.setAttribute("allUsersList", LogicFacade.getAllUsers());


        return "userpage";
    }
}
