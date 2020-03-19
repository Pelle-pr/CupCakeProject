package PresentationLayer;

import DB.UserMapper;
import FunctionLayer.Basket;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Set;

public class NewOrder extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {

        HttpSession session = request.getSession();

        int totalSum = (int) session.getAttribute("totalSum");
        int saldo = (int) session.getAttribute("saldo");
        int user_id = (int) session.getAttribute("user_id");

        Set<Basket> basketSet = (Set<Basket>) session.getAttribute("basket");

           if (saldo >= totalSum) {
            DB.OrderMapper.transaction(user_id, basketSet);
            UserMapper.opdaterSaldo(user_id,saldo-totalSum);
            basketSet.removeAll(basketSet);

          }
//        System.out.println("Du har ikke penge nok på din konto");

        return "customerpage" ;
    }
}
