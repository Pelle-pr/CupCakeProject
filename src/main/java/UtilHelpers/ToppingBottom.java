package UtilHelpers;

import DB.BottomMapper;
import DB.ToppingMapper;
import FunctionLayer.Bottom;
import FunctionLayer.Topping;

import java.util.ArrayList;

public class ToppingBottom {

    public static ArrayList<String> getToppings (){

        ArrayList<Topping> toppingArrayList = ToppingMapper.getAllToppings();
        ArrayList<String> toppingNames = new ArrayList<>();

        for (Topping topping : toppingArrayList) {
            toppingNames.add(topping.getName());

        }
        return  toppingNames;

    }
    public static ArrayList<String> getBottoms (){

        ArrayList<Bottom> bottomArrayList = BottomMapper.getAllBottoms();
        ArrayList<String> bottomNames = new ArrayList<>();

        for (Bottom bottom : bottomArrayList) {
            bottomNames.add(bottom.getName());

        }
        return  bottomNames;

    }
}
