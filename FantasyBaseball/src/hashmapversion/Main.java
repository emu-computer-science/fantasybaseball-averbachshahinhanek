package hashmapversion;

import java.util.*;

public class Main {
    //private static Map<Teams.Key, Teams> solarSystem = new HashMap<>();
    private static Map<Teams.Key, Teams> mapContainer = new HashMap<>();
    private static Set<Teams> leagueMembers = new HashSet<>();
    static Teams memberA = new TeamsMembers("memberA");
    static Teams memberB = new TeamsMembers("memberB");
    static Teams memberC = new TeamsMembers("memberC");
    static Teams memberD = new TeamsMembers("memberD");


    public static void main(String[] args) {
        addmembers(); //added 4 memebers with zero players as default



        Scanner scanner = new Scanner(System.in);

        String currPostion= "";
        //take string from the user if the
        ODRAFT ("joe",memberA,currPostion );

        printOptions();

//        while (true){
//            String playerName = scanner.nextLine();
//
//        }
        //pass the name of the player and player postion
//        Teams tempMoon = new Moon("Player1");
//        mapContainer.put(tempMoon.getKey(), tempMoon);
//        memberA.addPlayers(tempMoon);



    }

    private static void printOptions() {
        System.out.println("Choose for listed Options:\n \tOption 1:Enter player name, team, and position  \n \tOption 2:Enter player name, and postion  ");
    }


    static void IDRAFT(String playerName, String currPostion){//currentPosition is temp variable an will be used from the database
        ODRAFT (playerName,memberA,currPostion );
    }

    //This methods take players name, the member he is in and the currPosition
    private static void ODRAFT(String playerName, Teams players, String currPosition) {
        Teams player1;

        switch (currPosition){
            case "C":
                player1 = new Players.Catcher(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "1B":
                player1 = new Players.FirstBaseman(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "2B":
                player1 = new Players.SecondBaseman(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "3B":
                player1 = new Players.ThirdBaseman(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "SS":
                player1 = new Players.ShortStop(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "LF":
                player1 = new Players.LeftFielder(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "RF":
                player1 = new Players.RightFielder(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "CF":
                player1 = new Players.CenterFielder(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "P1":
                player1 = new Players.Pitcher1(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "P2":
                player1 = new Players.Pitcher2(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "P3":
                player1 = new Players.Pitcher3(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "P4":
                player1 = new Players.Pitcher4(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            case "P5":
                player1 = new Players.Pitcher5(playerName);
                mapContainer.put(player1.getKey(), player1);
                players.addPlayers(player1);
                break;
            default:
                System.out.println("Invalid player Position!!");


        }

    }


    static void addmembers(){
        //adding memberA
        memberA = new TeamsMembers("MemberA");
        mapContainer.put(memberA.getKey(), memberA);
        leagueMembers.add(memberA);

        //adding memberA
        memberB = new TeamsMembers("MemberB");
        mapContainer.put(memberB.getKey(), memberB);
        leagueMembers.add(memberB);

        //adding memberA
        memberC = new TeamsMembers("MemberC");
        mapContainer.put(memberC.getKey(), memberC);
        leagueMembers.add(memberC);

        //adding memberA
        memberD = new TeamsMembers("MemberD");
        mapContainer.put(memberD.getKey(), memberD);
        leagueMembers.add(memberD);

    }


}
