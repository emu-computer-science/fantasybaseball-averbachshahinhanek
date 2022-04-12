package testing;

import hashmapversion.Teams;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.util.*;

public class Main {
    private static String[] arguments = new String[5];
    private static League mlb = new League();

    public static void main(String[] args) throws Exception {
        //Implements script manager
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);


        mlb.addTeam("A");
        mlb.addTeam("B");
        mlb.addTeam("C");
        mlb.addTeam("D");

        //scan.nextLine();
        //Creation of databases
        DataBase db = new DataBase("Pitchers.txt", "Batters.txt");
//        db.initializePitcher(new File("Pitchers.txt"));
//        db.initializeBatters(new File("Batters.txt"));
        help();

        while(true) {
             System.out.print("->");
             String input = reader.readLine();
             arguments = input.split(" ");

            if(arguments[0].equalsIgnoreCase("ODRAFT") && arguments.length - 1 != 2) {
                arguments[1] = arguments[1].substring(1);
                arguments[2] = arguments[2].substring(0,arguments[2].length() - 1);
                db.getPlayer((arguments[1] + " " + arguments[2]), mlb.getTeam(arguments[3]));
            } else if(arguments[0].equalsIgnoreCase("IDRAFT")) {
                arguments[1] = arguments[1].substring(1);
                arguments[2] = arguments[2].substring(0,arguments[2].length() - 1);
                db.getPlayer((arguments[1] + " " + arguments[2]), mlb.getTeam(0)); //Uses the primary team.

            } else if(arguments[0].equalsIgnoreCase("OVERALL") && arguments.length - 1 < 1) {
                mlb.getTeam(0).displayPos(db.getAllNonPitchers());
            } else if(arguments[0].equalsIgnoreCase("OVERALL")) {
                mlb.getTeam(0).displayPos(arguments[1],db.getAllNonPitchers()); //Client team
            } else if(arguments[0].equalsIgnoreCase("POVERALL")) {
                mlb.getTeam(0).displayPitch(db.getPitcher());
            } else if(arguments[0].equalsIgnoreCase("TEAM") && arguments.length - 1 == 1 && arguments.length - 1 != 0){
                mlb.getTeam(arguments[1]).team(); //Prints out team in order of position
            } else if (arguments[0].equalsIgnoreCase("STARS") && arguments.length - 1 < 2) {
                mlb.getTeam(arguments[1]).stars(); //Executes STARS method
            } else if (arguments[0].equalsIgnoreCase("Quit")) { //Exits the Program
                System.out.println("Thank you for using our draft system.\nGoodbye!");
                break;
            } else if(arguments[0].equalsIgnoreCase("help")){
                help();
            } else if(arguments[0].equalsIgnoreCase("EVALFUN")){
                System.out.println(arguments[1]);
            } else if(arguments[0].equalsIgnoreCase("PVALFUN")){
                System.out.println(arguments[1]);
            } else if(arguments[0].equalsIgnoreCase("save")){
                onSerializeTeams(mlb, mlb.getTeams());
            } else if(arguments[0].equalsIgnoreCase("restore")){
                onDeserializeTeams();
            }else {
                System.out.println("Invalid command\n");
            }
        }
    }

    static void help(){
        System.out.println("Please enter one of the following commands:\n\tODRAFT [playername] [league member]\n\t" +
                "IDRAFT [playername]\n\tOVERALL [position]\n\tPOVERALL\n\tTEAM [team name]\n\tSTARS [team name]\n\tSAVE\n\tRESTORE\n\tHelp\n\tQuit");
    }
    //Credit to the Integerset provided resources:https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/
    //Serialize teams and save them to file. That includes its sub indexes
    private static void onSerializeTeams(League teams, ArrayList<Team> listTeams)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("teams.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listTeams);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    //Credit to the Integerset provided resources:https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/
    //get the data from the text file and set it to Teams
    private static void onDeserializeTeams()
    {
        try
        {
            FileInputStream fis = new FileInputStream("teams.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            mlb.setTeams((ArrayList) ois.readObject());

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

    }


}
