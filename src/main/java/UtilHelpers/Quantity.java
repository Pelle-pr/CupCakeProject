package UtilHelpers;

import java.util.ArrayList;

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

