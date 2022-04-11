package testing;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

import javax.script.ScriptException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


////PLAYER1 PLAYER2 TEAM ERA G GS IP HB BB SO

public class p_e_valfun {

    public static double evalFun(String evalExp, ArrayList<String> playerStat) throws UnparsableExpressionException, UnknownFunctionException, FileNotFoundException {


        Calculable calc = new ExpressionBuilder(evalExp)
                .withVariableNames("AVG", "OBP", "AB", "SLG", "SB")
                .build();
        calc.setVariable("AVG", Double.parseDouble(playerStat.get(9)));; //<-- Here is where we would call the function to get the player AVG
        calc.setVariable("OBP", Double.parseDouble(playerStat.get(10)));
        calc.setVariable("AB", Double.parseDouble((playerStat.get(4))));
        calc.setVariable("SLG", Double.parseDouble(playerStat.get(11)));
        calc.setVariable("SB", Double.parseDouble(playerStat.get(8)));

        Double calculation = calc.calculate();
        System.out.println(calculation);
        return(calculation);
    }

    public static void getValue(String evalFunction) throws IOException {


        int x = 0;
        String line = null;
        String splitBy = " ";
        FileWriter writer = null;
        try {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\aladdin\\Desktop\\fantasybaseball-averbachshahinhanek\\Batters.txt")); // Path of DB File
            writer = new FileWriter("C:\\Users\\aladdin\\Desktop\\fantasybaseball-averbachshahinhanek\\evalfun.csv");
            writer.write("FIRST LAST POSITION TEAM AB R H HR SB AVG OBP SLG EVALFUN\n");

            while ((line = reader.readLine()) != null)  //returns a Boolean value
            {
                if (x == 0) { //skipping the first line because it has column titles
                    x = x + 1;
                } else {
                    String[] strSplit = line.split(splitBy);
                    ArrayList<String> playerStat = new ArrayList<String>(
                            Arrays.asList(strSplit));
                    System.out.println(playerStat);

                    Double result = evalFun(evalFunction, playerStat);

                    playerStat.add(String.valueOf(result));
                    System.out.println(playerStat);

                    String collect = String.join(" ", playerStat);
                    writer.write(collect+"\n");


                }
            }
        } catch (IOException | UnparsableExpressionException | UnknownFunctionException e) {
            e.printStackTrace();

        }
        assert writer != null;
        writer.close();
    }




    public static void main(String[] args) throws ScriptException, UnparsableExpressionException, UnknownFunctionException, IOException {

        getValue("(SLG + SB) - 2");
        String sTest = "SLG + SB - 2";
        //evalfun(sTest);

    }


    }