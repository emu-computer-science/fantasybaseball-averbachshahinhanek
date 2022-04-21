package testing;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

import javax.script.ScriptException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


////PLAYER1 PLAYER2 TEAM ERA G GS IP HB BB SO
//G, GS, ERA, IP, BB
public class p_e_valfun {

    public static double pvalFun(String evalExp, ArrayList<String> playerStat) throws UnparsableExpressionException, UnknownFunctionException, FileNotFoundException {


        Calculable calc = new ExpressionBuilder(evalExp)
                .withVariableNames("G", "GS", "ERA", "IP", "BB")
                .build();
        calc.setVariable("G", Double.parseDouble(playerStat.get(5)));; //<-- Here is where we would call the function to get the player AVG
        calc.setVariable("GS", Double.parseDouble(playerStat.get(6)));
        calc.setVariable("ERA", Double.parseDouble((playerStat.get(4))));
        calc.setVariable("IP", Double.parseDouble(playerStat.get(7)));
        calc.setVariable("BB", Double.parseDouble(playerStat.get(9)));
        double calculation = calc.calculate();

        System.out.println("\nPVALFUN: " + calculation);

        return calc.calculate();
    }

    public static double evalFun(String evalExp, ArrayList<String> playerStat) throws UnparsableExpressionException, UnknownFunctionException, FileNotFoundException {


        Calculable calc = new ExpressionBuilder(evalExp)
                .withVariableNames("AVG", "OBP", "AB", "SLG", "SB")
                .build();
        calc.setVariable("AVG", Double.parseDouble(playerStat.get(9)));; //<-- Here is where we would call the function to get the player AVG
        calc.setVariable("OBP", Double.parseDouble(playerStat.get(10)));
        calc.setVariable("AB", Double.parseDouble((playerStat.get(4))));
        calc.setVariable("SLG", Double.parseDouble(playerStat.get(11)));
        calc.setVariable("SB", Double.parseDouble(playerStat.get(8)));

        double calculation = calc.calculate();
        System.out.println("\nEVALFUN: " + calculation);
        return(calculation);
    }

    public static void getEvalFun(String evalFunction) throws IOException {


        int x = 0;
        String line = null;
        String splitBy = " ";
        FileWriter writer = null;
        try {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader reader = new BufferedReader(new FileReader("Batters.txt")); // Path of DB File
            writer = new FileWriter("BattersTemp.txt"); // Path to create a new evalfun csv file
            writer.write("FIRST LAST POSITION TEAM AB R H HR SB AVG OBP SLG EVALFUN\n");

            while ((line = reader.readLine()) != null)  //returns a Boolean value
            {
                if (x == 0) { //skipping the first line because it has column titles
                    x = x + 1;
                } else {
                    String[] strSplit = line.split(splitBy);
                    ArrayList<String> playerStat = new ArrayList<String>(
                            Arrays.asList(strSplit));
                    //System.out.println(playerStat);

                    Double result = evalFun(evalFunction, playerStat);

                    playerStat.add(String.valueOf(result));
                    System.out.println(playerStat);

                    String collect = String.join(" ", playerStat);
                    writer.write(collect+"\n");


                }
            }
            reader.close();
        } catch (IOException | UnparsableExpressionException | UnknownFunctionException e) {
            e.printStackTrace();

        }
        assert writer != null;
        writer.close();

        File cfgFilePath = new File("BattersTemp.txt") ;
        File strTarget = new File("Batters.txt");
        Path from = cfgFilePath.toPath(); //convert from File to Path
        Path to = Paths.get(String.valueOf(strTarget)); //convert from String to Path
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
    }


    public static void getPvalFun(String pvalFunction) throws IOException {


        int x = 0;
        String line = null;
        String splitBy = " ";
        FileWriter writer = null;
        try {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader reader = new BufferedReader(new FileReader("Pitchers.txt")); // Path of DB File
            writer = new FileWriter("PitchersTemp.txt");// Path to create a new pvalfun csv file
            writer.write("PLAYER1 PLAYER2 TEAM ERA G GS IP HB BB SO PVALFUN\n");

            while ((line = reader.readLine()) != null)  //returns a Boolean value
            {
                if (x == 0) { //skipping the first line because it has column titles
                    x = x + 1;
                } else {
                    String[] strSplit = line.split(splitBy);
                    ArrayList<String> playerStat = new ArrayList<String>(
                            Arrays.asList(strSplit));
                    //System.out.println(playerStat);

                    Double result = pvalFun(pvalFunction, playerStat);

                    playerStat.add(String.valueOf(result));
                    System.out.println(playerStat);

                    String collect = String.join(" ", playerStat);
                    writer.write(collect+"\n");


                }
            }
            reader.close();




        } catch (IOException | UnparsableExpressionException | UnknownFunctionException e) {
            e.printStackTrace();

        }
        assert writer != null;
        writer.close();
        File cfgFilePath = new File("PitchersTemp.txt") ;
        File strTarget = new File("Pitchers.txt");
        Path from = cfgFilePath.toPath(); //convert from File to Path
        Path to = Paths.get(String.valueOf(strTarget)); //convert from String to Path
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);



    }




    public static void main(String[] args) throws ScriptException, UnparsableExpressionException, UnknownFunctionException, IOException {

        //getEvalFun("(SLG + SB) - 2");

        //G, GS, ERA, IP, BB
        getPvalFun(("(GS + IP) - 2"));
        String sTest = "SLG + SB - 2";
        //evalfun(sTest);

    }


    }