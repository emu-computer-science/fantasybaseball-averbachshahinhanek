package testing;

//This class uses recursive methods to navigate through the expression tree
public class Eval {
    //Node class which is the node in the evaluation tree
    public static class Node {
        String data;
        Node left, right; //The left and right sides of the expression tree

        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
