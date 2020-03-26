package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Ligger en ny cupcake is kurven, med de Topping, Bottom og Quantity parametre som brugeren har valgt på frontend.
 */

public class NewCupCake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        int bottom_id = Integer.parseInt(request.getParameter("bottom"));
        int topping_id = Integer.parseInt(request.getParameter("topping"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ArrayList<Bottom> bottomArrayList = (ArrayList<Bottom>) session.getServletContext().getAttribute("bottomlist");
        ArrayList<Topping> toppingArrayList = (ArrayList<Topping>) session.getServletContext().getAttribute("toppinglist");

        Bottom bottom = findBottom(bottom_id, bottomArrayList);
        Topping topping = findTopping(topping_id, toppingArrayList);



        CupCake cupCake = new CupCake(bottom,topping,quantity);

        Basket basket = (Basket) session.getAttribute("basket");

        if(basket == null){
             basket = new Basket(cupCake);
        } else {
            basket.addCupcake(cupCake);
        }
        session.setAttribute("basket",basket);

        int totalSum = basket.getTotalSum();
        session.setAttribute("totalSum", totalSum);

        return "customerpage" ;
    }

    /**
     * Finder hvilken bottom brugeren har valgt udfra bottom ID.
     * @param bottom_id // Request.parameteret
     * @param bottomArrayList
     * @return
     */

    private Bottom findBottom(int bottom_id, ArrayList<Bottom> bottomArrayList) {


        for (Bottom bottom : bottomArrayList) {
            if (bottom.getId() == bottom_id) {
                return bottom;
            }

        }
        return null;
    }
    /**
     * Finder hvilken topping brugeren har valgt udfra topping ID.
     * @param topping_id // Request.parameteret
     * @param toppingArrayList
     * @return
     */
    private Topping findTopping(int topping_id, ArrayList<Topping> toppingArrayList) {


        for (Topping topping : toppingArrayList) {
            if (topping.getId() == topping_id) {
                return topping;
            }

        }
        return null;
    }


}