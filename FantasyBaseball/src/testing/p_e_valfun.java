package testing;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.jetbrains.annotations.NotNull;

import javax.script.ScriptException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
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
        calc.setVariable("BB", Double.parseDouble(playerStat.get(8)));
        double calculation = calc.calculate();

        //System.out.println("\nPVALFUN: " + calculation);

        return calc.calculate();
    }

    public static double evalFun(String evalExp, @NotNull ArrayList<String> playerStat) throws UnparsableExpressionException, UnknownFunctionException, FileNotFoundException {

        //FIRST LAST POSITION TEAM AB R H HR SB AVG OBP SLG EVALFUN
        //System.out.println(playerStat);
        Calculable calc = new ExpressionBuilder(evalExp)
                .withVariableNames("AVG", "OBP", "AB", "SLG", "SB")
                .build();
        calc.setVariable("AVG", Double.parseDouble(playerStat.get(9)));; //<-- Here is where we would call the function to get the player AVG
        calc.setVariable("OBP", Double.parseDouble(playerStat.get(10)));
        calc.setVariable("AB", Double.parseDouble((playerStat.get(4))));
        calc.setVariable("SLG", Double.parseDouble(playerStat.get(10)));
        calc.setVariable("SB", Double.parseDouble(playerStat.get(8)));

        double calculation = calc.calculate();
        //System.out.println("\nEVALFUN: " + calculation);
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
                if (line.equals("FIRST LAST POSITION TEAM AB R H HR SB AVG OBP SLG") || line.equals("FIRST LAST POSITION TEAM AB R H HR SB AVG OBP SLG EVALFUN")) { //skipping the first line because it has column titles

                }else {
                    String[] strSplit = line.split(splitBy);
                    ArrayList<String> playerStat = new ArrayList<String>(Arrays.asList(strSplit));
                    //System.out.println(playerStat);
                    if (playerStat.size() <= 11) {

                        Double result = evalFun(evalFunction, playerStat);

                        playerStat.add(String.valueOf(result));
                        //System.out.println(playerStat);

                        String collect = String.join(" ", playerStat);
                        writer.write(collect + "\n");
                    }
                    else{
                        //System.out.println("Deleting");
                        int index = playerStat.size() - 1;
                        playerStat.remove(index);
                        Double result = evalFun(evalFunction, playerStat);

                        playerStat.add(String.valueOf(result));
                        //System.out.println(playerStat);

                        String collect = String.join(" ", playerStat);
                        writer.write(collect + "\n");
                    }
            }}
            reader.close();
        } catch (IOException | UnparsableExpressionException | UnknownFunctionException e) {
            e.printStackTrace();

        }
        assert writer != null;
        writer.close();
        fileReplace("BattersTemp.txt","Batters.txt");

        getSortEval();
    }


    public static void getPvalFun(String pvalFunction) throws IOException {


        int x = 0;
        String line = null;
        String splitBy = " ";
        FileWriter writer = null;


        try {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader reader = new BufferedReader(new FileReader("Pitchers.txt")); // Path of DB File
            writer = new FileWriter("PitchersTemp.txt",false);// Path to create a new pvalfun csv file
            //writer.write("");
            writer.write("PLAYER1 PLAYER2 TEAM ERA G GS IP HB BB SO PVALFUN\n");

            while ((line = reader.readLine()) != null)  //returns a Boolean value
                //System.out.println(line);
            {
                if (line.equals("PLAYER1 PLAYER2 TEAM ERA G GS IP HB BB SO") || line.equals("PLAYER1 PLAYER2 TEAM ERA G GS IP HB BB SO PVALFUN")) {
                        //skipping the first line because it has column titles
                }
                else {
                    String[] strSplit = line.split(splitBy);
                    ArrayList<String> playerStat = new ArrayList<String>(Arrays.asList(strSplit));
                    //System.out.println(playerStat);
                    if (playerStat.size() <= 10) {

                        Double result = pvalFun(pvalFunction, playerStat);

                        playerStat.add(String.valueOf(result));
                        //System.out.println(playerStat);

                        String collect = String.join(" ", playerStat);
                        writer.write(collect + "\n");
                    }
                    else{
                        //System.out.println("Deleting");
                        int index = playerStat.size() - 1;
                        playerStat.remove(index);
                        Double result = pvalFun(pvalFunction, playerStat);

                        playerStat.add(String.valueOf(result));
                        //System.out.println(playerStat);

                        String collect = String.join(" ", playerStat);
                        writer.write(collect + "\n");
                    }

                }
            }
            reader.close();




        } catch (IOException | UnparsableExpressionException | UnknownFunctionException e) {
            e.printStackTrace();

        }
        assert writer != null;
        writer.close();

        fileReplace("PitchersTemp.txt","Pitchers.txt");

        getSort();



    }


    public static void fileReplace(String fileToRead, String fileToReplace) throws IOException {
        File cfgFilePath = new File(fileToRead) ;
        File strTarget = new File(fileToReplace);

        Path from = cfgFilePath.toPath(); //convert from File to Path
        Path to = strTarget.toPath(); //convert from String to Path
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

        

        close();



    }

    private static void close() {
    }


    public static void removeFirstLine() throws IOException {
        BufferedReader brTest = new BufferedReader(new FileReader("Pitchers.txt"));
        String text = brTest.readLine();
            //System.out.println(text);
        brTest.mark(0);



            RandomAccessFile raf = new RandomAccessFile("Pitchers.txt", "rw");
        //System.out.println(text);
        brTest.close();


        if (text.equals("PLAYER1 PLAYER2 TEAM ERA G GS IP HB BB SO") || text.equals("PLAYER1 PLAYER2 TEAM ERA G GS IP HB BB SO PVALFUN")) {
            //System.out.println("DELETED");
            long writePosition = raf.getFilePointer();
            raf.readLine();
            //System.out.println(raf.readLine());

            // Shift the next lines upwards.
            long readPosition = raf.getFilePointer();

            byte[] buff = new byte[1024];
            int n;
            while (-1 != (n = raf.read(buff))) {
                raf.seek(writePosition);
                raf.write(buff, 0, n);
                readPosition += n;
                writePosition += n;
                raf.seek(readPosition);
            }
            raf.setLength(writePosition);
            raf.close();
        }
        raf.close();


    }

    public static void getSort() throws IOException {
        removeFirstLine();
        String filePath = "Pitchers.txt";

        String content = Files.lines(Path.of(filePath))
                .sorted(Comparator.comparing(line -> Float.parseFloat(line.split(" ")[10])))
                .collect(Collectors.joining("\n"));

        Files.write(Paths.get("PitchersSorted.txt"), content.getBytes());

        String content1 = "\nPLAYER1 PLAYER2 TEAM ERA G GS IP HB BB SO PVALFUN\n";
        //String path = "PitchersSorted.txt";
        Path path = Paths.get("PitchersSorted.txt");
        Files.writeString(path, content1,StandardOpenOption.APPEND);

        try {
            BufferedReader input = new BufferedReader(new FileReader("PitchersSorted.txt"));
            input.mark(0);

            ArrayList list = new ArrayList();
            String line;
            while ((line = input.readLine()) != null) {

                list.add(line);
            }
            input.close();

            Collections.reverse(list);

            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("PitchersSorted.txt")));

            for (Iterator i = list.iterator(); i.hasNext();) {
                output.println((String) i.next());
            }
            output.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        fileReplace("PitchersSorted.txt","Pitchers.txt");




    }

    public static void getSortEval() throws IOException {
        removeFirstLineEval();
        String filePath = "Batters.txt";

        String content = Files.lines(Path.of(filePath))
                .sorted(Comparator.comparing(line -> Float.parseFloat(line.split(" ")[11])))
                .collect(Collectors.joining("\n"));

        Files.write(Paths.get("BattersSorted.txt"), content.getBytes());

        String content1 = "\nFIRST LAST POSITION TEAM AB R H HR SB AVG OBP SLG EVALFUN\n";
        //String path = "PitchersSorted.txt";
        Path path = Paths.get("BattersSorted.txt");
        Files.writeString(path, content1,StandardOpenOption.APPEND);

        try {
            BufferedReader input = new BufferedReader(new FileReader("BattersSorted.txt"));
            input.mark(0);

            ArrayList list = new ArrayList();
            String line;
            while ((line = input.readLine()) != null) {

                list.add(line);
            }
            input.close();

            Collections.reverse(list);

            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("BattersSorted.txt")));

            for (Iterator i = list.iterator(); i.hasNext();) {
                output.println((String) i.next());
            }
            output.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        fileReplace("BattersSorted.txt","Batters.txt");




    }
    public static void removeFirstLineEval() throws IOException {
        BufferedReader brTest = new BufferedReader(new FileReader("Batters.txt"));
        String text = brTest.readLine();
        //System.out.println(text);
        brTest.mark(0);



        RandomAccessFile raf = new RandomAccessFile("Batters.txt", "rw");
        //System.out.println(text);
        brTest.close();


        if (text.equals("FIRST LAST POSITION TEAM AB R H HR SB AVG OBP SLG EVALFUN") || text.equals("PLAYER1 PLAYER2 TEAM ERA G GS IP HB BB SO")) {
            //System.out.println("DELETED");
            long writePosition = raf.getFilePointer();
            raf.readLine();
            //System.out.println(raf.readLine());

            // Shift the next lines upwards.
            long readPosition = raf.getFilePointer();

            byte[] buff = new byte[1024];
            int n;
            while (-1 != (n = raf.read(buff))) {
                raf.seek(writePosition);
                raf.write(buff, 0, n);
                readPosition += n;
                writePosition += n;
                raf.seek(readPosition);
            }
            raf.setLength(writePosition);
            raf.close();
        }
        raf.close();


    }






    public static void main(String[] args) throws ScriptException, UnparsableExpressionException, UnknownFunctionException, IOException {

        //getEvalFun("(SLG + SB) - 2");

        //G, GS, ERA, IP, BB
        getPvalFun(("IP"));
        getEvalFun(("AB"));
        //removeFirstLine();
        //getSort();
        //String sTest = "SLG + SB - 2";
        //evalfun(sTest);

    }


    }