package UtilHelpers;

import DB.BottomMapper;
import DB.ToppingMapper;
import FunctionLayer.Bottom;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import java.util.ArrayList;

public class ToppingBottom {

    public static ArrayList<String> getToppings () throws LoginSampleException{

        ArrayList<Topping> toppingArrayList = ToppingMapper.getAllToppings();
        ArrayList<String> toppingNames = new ArrayList<>();

        for (Topping topping : toppingArrayList) {
            toppingNames.add(topping.getName());
            System.out.println(topping.getName());
        }
        return  toppingNames;

    }
    public static ArrayList<String> getBottoms ()  throws LoginSampleException {

        ArrayList<Bottom> bottomArrayList = BottomMapper.getAllBottoms();
        ArrayList<String> bottomNames = new ArrayList<>();

        for (Bottom bottom : bottomArrayList) {
            bottomNames.add(bottom.getName());
            System.out.println(bottom.getName());

        }
        return  bottomNames;

    }
}
