package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Userpage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ServletException, IOException {

        HttpSession session = request.getSession();

        session.setAttribute("allUsersList", LogicFacade.getAllUsers());

        int user_id = (int) request.getAttribute("saldo");
        int money = (int) request.getAttribute("money");

        LogicFacade.insertMoney(user_id, money);

        return "userpage";
        }
    }

