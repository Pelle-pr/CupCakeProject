package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NewCupCake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        int bottom_id = Integer.parseInt(request.getParameter("bottom"));
        int topping_id = Integer.parseInt(request.getParameter("topping"));

        ArrayList<Bottom> bottomArrayList = (ArrayList<Bottom>) session.getAttribute("bottomlist");
        ArrayList<Topping> toppingArrayList = (ArrayList<Topping>) session.getAttribute("toppinglist");

        Bottom bottom = findBottom(bottom_id, bottomArrayList);
        Topping topping = findTopping(topping_id, toppingArrayList);


        int quantity = Integer.parseInt(request.getParameter("quantity"));

        CupCake cupCake = new CupCake(bottom,topping,quantity);

        Basket basket = new Basket(cupCake);



        if(session.getAttribute("basket")== null){

            Set<Basket> basketSet = new HashSet<>();

            session.setAttribute("basket",basketSet);

        }
        ((Set<Basket>) session.getAttribute("basket")).add(basket);



        int totalSum = getTotalBasketSum((Set<Basket>) session.getAttribute("basket"));
        session.setAttribute("totalSum", totalSum);

        return "customerpage" ;
    }

    private Bottom findBottom(int bottom_id, ArrayList<Bottom> bottomArrayList) {


        for (Bottom bottom : bottomArrayList) {
            if (bottom.getId() == bottom_id) {
                return bottom;
            }

        }
        return null;
    }
    private Topping findTopping(int bottom_id, ArrayList<Topping> toppingArrayList) {


        for (Topping topping : toppingArrayList) {
            if (topping.getId() == bottom_id) {
                return topping;
            }

        }
        return null;
    }
    private int getTotalBasketSum (Set<Basket> basketSet){

        int res = 0;
        for (Basket basket : basketSet) {
            res = res + basket.getCupCake().getSum();

        }
        return res;
    }


}