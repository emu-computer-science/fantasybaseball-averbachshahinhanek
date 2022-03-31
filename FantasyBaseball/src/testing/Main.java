package testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static String[] arguments = new String[5];

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        League mlb = new League();
        System.out.println("Please add 4 teams:");

        //Add 4 teams
        for(int i = 0; i < 4; i++) {
            mlb.addTeam(reader.readLine());
        }

        //scan.nextLine();
        //Creation of databases
        DataBase db = new DataBase();
        db.initializePitcher(new File("C:/users/averb/Documents/COSC_381/Semester Project 1/Data/Pitchers.txt"));
        db.initializeBatters(new File("C:/users/averb/Documents/COSC_381/Semester Project 1/Data/Batters.txt"));


        while(true) {
            System.out.println("Please enter one of the following commands:\n\tODRAFT [playername] [league member]\n\t" +
                    "IDRAFT [playername]\n\tOVERALL [position]\n\tPOVERALL");

             String input = reader.readLine();
             arguments = input.split(" ");

            if(arguments[0].equals("ODRAFT")) {
                db.getPlayer((arguments[1] + " " + arguments[2]), mlb.getTeam(arguments[3]));
            } else if(arguments[0].equals("IDRAFT")) {
                db.getPlayer((arguments[1] + " " + arguments[2]), mlb.getTeam(0)); //Uses the primary team.
            } else if(arguments[0].equals("OVERALL") && arguments.length - 1 < 1) {
                mlb.getTeam(0).displayPos(db.getAllNonPitchers());
            } else if(arguments[0].equals("OVERALL")) {
                mlb.getTeam(0).displayPos(arguments[1],db.getAllNonPitchers()); //Client team
            } else if(arguments[0].equals("POVERALL")) {
                mlb.getTeam(0).displayPitch(db.getPitcher());
            } else if(arguments[0].equals("TEAM") && arguments.length - 1 == 1){
                for(Team i : mlb.getTeams()) {
                    if(i.getName().equals(arguments[1])){
                        i.printTeam();
                    }
                }
            }

            System.out.print("\nExit? (Y/N): ");
            if(reader.readLine().equalsIgnoreCase("Y")) {
                reader.close();
                break;
            } else
                continue;
        }
    }
}
