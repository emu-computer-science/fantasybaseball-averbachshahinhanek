package testing;

import java.io.File;
import java.util.*;

public class Main {
    //private static Map<Teams.Key, Teams> solarSystem = new HashMap<>();
    private static Map<Teams.Key, Teams> mapContainer = new HashMap<>();
    private static Set<Teams> leagueMembers = new HashSet<>();

    private static String[] arguments = new String[5];
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Teams team1, team2, team3, team4;
        System.out.println("Please add 4 teams:");

        team1 = new TeamsMembers(scan.next());
        team2 = new TeamsMembers(scan.next());
        team3 = new TeamsMembers(scan.next());
        team4 = new TeamsMembers(scan.next());

        mapContainer.put(team1.getKey(),team1);
        mapContainer.put(team2.getKey(),team2);
        mapContainer.put(team3.getKey(),team3);
        mapContainer.put(team4.getKey(), team4);

        //Creation of databases
        DataBase db = new DataBase();
        db.initializePitcher(new File("C:/users/averb/Documents/COSC_381/Semester Project 1/Data/Pitchers.txt"));
        db.initializeBatters(new File("C:/users/averb/Documents/COSC_381/Semester Project 1/Data/Batters.txt"));


        while(true) {
            System.out.println("Please enter one of the following commands:\n\tODRAFT [playername] [league member]\n\t" +
                    "IDRAFT [playername]\n\tOVERALL [position]\n\tPOVERALL");
            String input = scan.next();
            arguments = input.split(" ");

            String currTeam;
            System.out.print("Please select a team: ");
            currTeam = scan.next();

            if(arguments[0].equals("ODRAFT")) {
                for(Teams.Key item : mapContainer.keySet()) {
                    if(item.getName().equalsIgnoreCase(arguments[2])) {
                        //TODO NEED TO F
                    }
                }
            } else if(arguments[0].equals("IDRAFT")) {

            } else if(arguments[0].equals("OVERALL")) {

            } else if(arguments[0].equals("POVERALL")) {

            } else {
                System.out.println("Invalid command/arguments");
            }
        }
    }
}
