package hashmapversion;

import java.util.*;

public class Main
{
    //private static Map<Teams.Key, Teams> solarSystem = new HashMap<>();
    private static final Map<Teams.Key, Teams> mapContainer = new HashMap<>();
    private static final Set<Teams> leagueMembers = new HashSet<>();
    static Teams memberA = new TeamsMembers("memberA");
    static Teams memberB = new TeamsMembers("memberB");
    static Teams memberC = new TeamsMembers("memberC");
    static Teams memberD = new TeamsMembers("memberD");
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args)
    {
        addmembers(); //added 4 memebers with zero players as default

        String currPostion = "";

        printOptions();
        do
        {
            System.out.print(">> ");
            String name = scanner.nextLine();
            name = name.replace("\"", "");//removing double quotes
            name = name.replace(",", "");//removing double quotes
            String[] str = name.split(" ");
            String key = str[0].toUpperCase();
            switch (key)
            {
                case "IDRAFT":
                    IDRAFT(str[1] + " " + str[2], str[3]);//postion three is temp

                    break;
                case "ODRAFT":
                    ODRAFT(String.format("%s %s", str[1], str[2]), getMember(str[3].toUpperCase()), str[4]);
                    break;
                case "TEAM":
                    printTeam(leagueMembers, str[1].toUpperCase());
                    break;
                case "STARS":
                    System.out.println("to be implemented ");
                    break;
                case "SAVE":
                    System.out.println("to be implemented ");
                    break;
                case "QUIT":
                    System.out.println("to be implemented ");
                    break;
                default:
                    System.out.println("ERROR:\n" +
                            "Invalid first Keyword, Type one of the following commands: " +
                            "\n--------------- IDRAFT, ODRAFT, TEAM, STARS, SAVE, QUIT ---------------");
                    break;
            }

        } while (true);


    }

    private static Teams getMember(String str)
    {
        switch (str)
        {
            case "A":
                return memberA;
            case "B":
                return memberB;
            case "C":
                return memberC;
            case "D":
                return memberD;
        }
        return null;
    }


    private static void printOptions()
    {
        System.out.println("\nChoose for listed Options:\n \tOption 1:Enter player name, team, and position: ODraft " +
                " \n \tOption 2:Enter player name, and postion: IDRAFT  ");


    }


    static void IDRAFT(String playerName, String currPostion)
    {//currentPosition is temp variable an will be used from the database
        ODRAFT(playerName, memberA, currPostion);
    }

    //This methods take players name, the member he is in and the currPosition
    private static void ODRAFT(String playerName, Teams players, String currPosition)
    {
        Teams player1;

        String currPositionUpperCase = currPosition.toUpperCase();
        switch (currPositionUpperCase)
        {
            case "C":
                player1 = new Players.Catcher(playerName);
                if (isPositionTaken(leagueMembers, "CATCHER"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "1B":
                player1 = new Players.FirstBaseman(playerName);
                if (isPositionTaken(leagueMembers, "FIRST_BASEMAN"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "2B":
                player1 = new Players.SecondBaseman(playerName);
                if (isPositionTaken(leagueMembers, "SECOND_BASEMAN"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "3B":
                player1 = new Players.ThirdBaseman(playerName);
                if (isPositionTaken(leagueMembers, "THIRD_BASEMAN"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "SS":
                player1 = new Players.ShortStop(playerName);
                if (isPositionTaken(leagueMembers, "SHORT_STOP"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "LF":
                player1 = new Players.LeftFielder(playerName);
                if (isPositionTaken(leagueMembers, "LEFT_FIELDER"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "RF":
                player1 = new Players.RightFielder(playerName);
                if (isPositionTaken(leagueMembers, "RIGHT_FIELDER"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "CF":
                player1 = new Players.CenterFielder(playerName);
                if (isPositionTaken(leagueMembers, "CENTER_FIELDER"))
                {
                    System.out.println("Position is taken: No player was drafted");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted.");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "P1":
                player1 = new Players.Pitcher1(playerName);
                if (isPositionTaken(leagueMembers, "PICHER1"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "P2":
                player1 = new Players.Pitcher2(playerName);
                if (isPositionTaken(leagueMembers, "PICHER2"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "P3":
                player1 = new Players.Pitcher3(playerName);
                if (isPositionTaken(leagueMembers, "PICHER3"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "P4":
                player1 = new Players.Pitcher4(playerName);
                if (isPositionTaken(leagueMembers, "PICHER4"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            case "P5":
                player1 = new Players.Pitcher5(playerName);
                if (isPositionTaken(leagueMembers, "PICHER5"))
                {
                    System.out.println("Position is taken: No player was drafted.");
                }
                if (isTaken(mapContainer, playerName))
                {//if player is taken
                    System.out.println("Player already taken: No player was drafted");
                    break;
                } else
                {//Add the player if player doesn't exist
                    mapContainer.put(player1.getKey(), player1);
                    players.addPlayers(player1);
                }
                break;
            default:
                System.out.println("Invalid player Position!!");


        }

    }


    static void addmembers()
    {
        //adding memberA
        memberA = new TeamsMembers("A");
        mapContainer.put(memberA.getKey(), memberA);
        leagueMembers.add(memberA);

        //adding memberA
        memberB = new TeamsMembers("B");
        mapContainer.put(memberB.getKey(), memberB);
        leagueMembers.add(memberB);

        //adding memberA
        memberC = new TeamsMembers("C");
        mapContainer.put(memberC.getKey(), memberC);
        leagueMembers.add(memberC);

        //adding memberA
        memberD = new TeamsMembers("D");
        mapContainer.put(memberD.getKey(), memberD);
        leagueMembers.add(memberD);

    }

    private static boolean isTaken(Map<Teams.Key, Teams> mapContainer, String playerName)
    {
        for (int i = 0; i < mapContainer.size(); i++)
        {
            if ((((Teams.Key) ((Map.Entry) ((HashMap) mapContainer).entrySet().toArray()[i]).getKey()).getName()).equals(playerName))
            {
                return true;
            }
        }

        return false;
    }

    // check if the player is already taken
    private static boolean isPositionTaken(Set<Teams> inLeagueMembers, String playerType)
    {
        for (int i = 0; i < inLeagueMembers.size(); i++)
        {
            for (int j = 0; j < ((TeamsMembers) inLeagueMembers.toArray()[i]).getPlayers().size(); j++)
            {
                if ((((((Teams) (((TeamsMembers) inLeagueMembers.toArray()[i]).getPlayers()).toArray()[j]).getKey()).getEntryType()).name()) == playerType)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printTeam(Set<Teams> inLeagueMembers, String teamName)
    {
        Teams teams = mapContainer.get(Teams.makeKey(teamName, Teams.EntryType.LEAGUE_MEMBER));
        System.out.println("The members of Team: " + teamName);
        for (Teams players : teams.getPlayers())
        {
            String[] str = String.valueOf(players.getKey()).split(" ");
            System.out.println("" + players.getKey());
        }
    }

    static String getPosition(String type)
    {
        switch (type)
        {
            case "CATCHER":
                return "C";

            case "FIRST_BASEMAN":
                return "1B";

            case "SECOND_BASEMAN":
                return "2B";

            case "THIRD_BASEMAN":
                return "3B";

            case "SHORT_STOP":
                return "SS";

            case "LEFT_FIELDER":
                return "LF";

            case "RIGHT_FIELDER":
                return "RT";

            case "CENTER_FIELDER":
                return "CF";

            case "PICHER1":
                return "P1";

            case "PICHER2":
                return "P2";

            case "PICHER3":
                return "P3";

            case "PICHER4":
                return "P4";

            case "PICHER5":
                return "P5";

        }
        return null;
    }

}
