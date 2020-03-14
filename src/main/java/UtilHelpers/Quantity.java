package UtilHelpers;

import DB.ToppingMapper;
import FunctionLayer.Topping;

import java.util.ArrayList;
import java.util.List;

public class Quantity {


    public static ArrayList <Integer> getQuantity (){

        ArrayList arrayList = new ArrayList();

        int start = 1;
        int slut = 11;

        for (int i = start; i < slut ; i++) {

            arrayList.add(i);

        }

        return arrayList;
    }



    }

