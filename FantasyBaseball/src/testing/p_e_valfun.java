package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Node{
    char data;
    Node left,right;
    public Node(char data){
        this.data = data;
        left = right = null;
    }
}

public class p_e_valfun {

    public static void inorder(Node root){
        if(root==null) return;

        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    public static void evalfunCreate(String starter){
        //AVG, OBP, AB, SLG, SB.
        String[] postfix = starter.split("\\s+");
        ArrayList<String> characters = new ArrayList<String>();
        ArrayList<String> operators = new ArrayList<String>();


        System.out.println(Arrays.toString(postfix));
        for (int i=0;i<postfix.length;i++) {
            switch (postfix[i]) {
                case "AVG" ->  //AVG = A
                        //postfix[i] = String.valueOf('A');
                        characters.add("A");
                case "OBP" ->  //OBP = O
                        //postfix[i] = String.valueOf('O');
                        characters.add("O");

                case "AB" ->  //AB = B
                        //postfix[i] = String.valueOf('B');
                        characters.add("B");

                case "SLG" ->  //SLG = S
                        //postfix[i] = String.valueOf('S');
                        characters.add("S");

                case "SB" ->  //SB = F
                        //postfix[i] = String.valueOf('F');
                        characters.add("F");

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




        System.out.println(operators);


        //System.out.println(characters);
        //System.out.println(operators);



    }
    public static void main(String[] args) {
        ////AVG, OBP, AB, SLG, SB.
        String postfix = "34 * OBP + SLG - SB";
        evalfunStart(postfix);
        //Node r = expressionTree(postfix);
        //inorder(r);
    }
}