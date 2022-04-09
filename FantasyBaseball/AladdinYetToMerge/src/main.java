import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter command");

        String command = myObj.nextLine();  // Read user input
        String[] strSplit = command.split(" ");
        ArrayList<String> commandArray = new ArrayList<String>(
                Arrays.asList(strSplit));

        System.out.println(commandArray.size());
        if (command.contains("EVALFUN")){
            //AVG, OBP, AB, SLG, SB.
            commandArray.remove(0);
            System.out.println("EVALFUN Inititated");
            System.out.println(commandArray.size());
            for (String s : commandArray) {
                System.out.println(s);
            }


        }
          // Output user input

    }
}
