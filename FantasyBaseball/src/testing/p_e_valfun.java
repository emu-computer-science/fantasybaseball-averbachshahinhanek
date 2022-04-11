package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class p_e_valfun {

    public static float getValue(String columName){
        // playerSearch = database[columName] <--- Return the value of the search
      return 20;
    };




    public static void evalfunCreate(String starter){
        //AVG, OBP, AB, SLG, SB.
        String[] postfix = starter.split("\\s+");
        ArrayList<String> characters = new ArrayList<String>();
        ArrayList<String> operators = new ArrayList<String>();
        float total = 0;

        System.out.println(Arrays.toString(postfix));
        for (int i=0;i<postfix.length;i++) {
            switch (postfix[i]) {
                case "AVG" -> {  //AVG = A
                    float AVG = 56;
                    total += AVG;
                }
                case "OBP" -> {
                    float OBP = 20;
                    total += OBP;
                }

                case "AB" -> {
                    float AB = 10;
                    total += AB;
                }

                case "SLG" -> {
                    float SLG = 19;
                    total += SLG;
                }

                case "SB" -> {

                    float AVG = 56;
                    total += AVG;
                }

                case "+" -> {
                    operators.add(0,"+");//operators
                }
                case "-" -> {//operators
                    operators.add(0,"-");//operators

                }
                case "/" -> {//operators
                    operators.add(0,"/");//operators

                }
                case "*" -> {//operators
                    operators.add(0,"*");//operators

                }
                default ->{
                    characters.add(0,postfix[i]);
                }

            }


        }
        characters.addAll(operators);




        System.out.println(characters);





    }
    public static void main(String[] args) {

    }
}