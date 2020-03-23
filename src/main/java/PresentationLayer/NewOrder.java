package PresentationLayer;

import DB.UserMapper;
import FunctionLayer.Basket;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public class NewOrder extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ServletException, IOException {


        HttpSession session = request.getSession();
        int totalSum = (int) session.getAttribute("totalSum");
        int saldo = (int) session.getAttribute("saldo");
        int user_id = (int) session.getAttribute("user_id");
        Basket basket = (Basket) session.getAttribute("basket");



            if (saldo >= totalSum) {
                int newSaldo = saldo - totalSum;
                DB.OrderMapper.transaction(user_id, basket);
                UserMapper.opdaterSaldo(user_id, newSaldo);
                basket.getCupCakeList().clear();
                session.setAttribute("saldo", newSaldo );

            }
          else
            request.setAttribute( "error", "Du har ikke penge nok på din konto - kontakt Admin!");

          session.setAttribute("totalSum", 0);
          return "customerpage" ;
    }
}
