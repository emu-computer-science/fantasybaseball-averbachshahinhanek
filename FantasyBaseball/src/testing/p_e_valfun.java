package testing;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.mockito.internal.matchers.Null;

import javax.script.ScriptException;
import java.io.*;
import java.util.Arrays;


////AVG, OBP, AB, SLG, SB.

public class p_e_valfun {

    public static double evalFun(String evalExp, String[] playerStat) throws UnparsableExpressionException, UnknownFunctionException, FileNotFoundException {

        System.out.println(playerStat[0]);

        Calculable calc = new ExpressionBuilder(evalExp)
                .withVariableNames("AVG", "OBP", "AB", "SLG", "SB")
                .build();
        calc.setVariable("AVG", Double.parseDouble(playerStat[9]));; //<-- Here is where we would call the function to get the player AVG
        calc.setVariable("OBP", Double.parseDouble(playerStat[10]));
        calc.setVariable("AB", Double.parseDouble((playerStat[4])));
        calc.setVariable("SLG", Double.parseDouble(playerStat[11]));
        calc.setVariable("SB", Double.parseDouble(playerStat[8]));

        Double calculation = calc.calculate();
        System.out.println(calculation);
        return(calculation);
    }

    public static double getValue(String evalFunction) throws FileNotFoundException {


        int x = 0;
        String line = null;
        String splitBy = " ";
        try
        {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\aladdin\\Desktop\\fantasybaseball-averbachshahinhanek\\Batters.txt"));
            while ((line = reader.readLine()) != null)  //returns a Boolean value
            {
                if (x == 0) { //skipping the first line because it has column titles
                    x = x + 1;
                }
                else{
                    String[] playerStat = line.split(splitBy);
                    System.out.println(playerStat[0]);
                    evalFun(evalFunction,playerStat);

                }
            }
        } catch (IOException | UnparsableExpressionException | UnknownFunctionException e) {
            e.printStackTrace();
        }
        return 0;
    }




    public static void main(String[] args) throws ScriptException, UnparsableExpressionException, UnknownFunctionException, FileNotFoundException {

        getValue("(SLG + SB) - 2");
        String sTest = "SLG + SB - 2";
        //evalfun(sTest);

    }


    }