package testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DataBase {

    ArrayList<NonPitcher> catchers = new ArrayList<>();
    ArrayList<NonPitcher> firstBase = new ArrayList<>();
    ArrayList<NonPitcher> secondBase = new ArrayList<>();
    ArrayList<NonPitcher> thirdBase = new ArrayList<>();
    ArrayList<NonPitcher> SS = new ArrayList<>();
    ArrayList<NonPitcher> leftField = new ArrayList<>();
    ArrayList<NonPitcher> centerField = new ArrayList<>();
    ArrayList<NonPitcher> rightField = new ArrayList<>();

    ArrayList<NonPitcher> allNonPitchers = new ArrayList<>();
    ArrayList<Pitcher> pitcher = new ArrayList<>();

    ArrayList<NonPitcher> draftedBatters = new ArrayList<>();
    ArrayList<Pitcher> draftedPitchers = new ArrayList<>();

    public DataBase() {}

    public void initializePitcher(File database) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(database));
        String data; //Holds contents of a line of the database
        String[] line = new String[10];

        //To store pitcher data
        while((data = reader.readLine()) != null) {
            line = data.split(",");
            pitcher.add(new Pitcher(line[0],line[2],"P",Double.parseDouble(line[6])));
        }
        reader.close();
    }

    public void initializeBatters(File database) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(database));
        String data; //Holds contents of a line of the database
        String[] line = new String[20];

        //To store pitcher data
        while((data = reader.readLine()) != null) {
            line = data.split(" ");

            if(line.length - 1 <= 15)
               allNonPitchers.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],0));
            else
                allNonPitchers.add(new NonPitcher((line[0] + " " + line[1]), line[3], line[2], Double.parseDouble(line[16])));

            switch(line[2]) {
                case "C":
                    if(line.length - 1 <= 15) {
                        catchers.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],0));
                        break;
                    }
                    catchers.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "1B":
                    if(line.length - 1 <= 15) {
                        firstBase.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],0));
                        break;
                    }
                    firstBase.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "2B":
                    if(line.length - 1 <= 15) {
                        secondBase.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],0));
                        break;
                    }
                    secondBase.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "3B":
                    if(line.length - 1 <= 15) {
                        thirdBase.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],0));
                        break;
                    }
                    thirdBase.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "SS":
                    if(line.length - 1 <= 15) {
                        SS.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],0));
                        break;
                    }
                    SS.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "LF":
                    if(line.length - 1 <= 15) {
                        leftField.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],0));
                        break;
                    }
                    leftField.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "CF":
                    if(line.length - 1 <= 15) {
                        centerField.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],0));
                        break;
                    }
                   centerField.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "RF":
                    if(line.length - 1 <= 15) {
                        rightField.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],0));
                        break;
                    }
                    rightField.add(new NonPitcher((line[0] + " " + line[1]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                default:
                    break;
            }
        }
        reader.close();
    }

    public void display(String position) {
        switch(position) {
            case "C":
                for(NonPitcher player : catchers)
                    System.out.println(player.toString());
                break;
            case "1B":
                for(NonPitcher player : firstBase)
                    System.out.println(player.toString());
                break;
            case "2B":
                for(NonPitcher player : secondBase)
                    System.out.println(player.toString());
                break;
            case "3B":
                for(NonPitcher player : thirdBase)
                    System.out.println(player.toString());
                break;
            case "SS":
                for(NonPitcher player : SS)
                    System.out.println(player.toString());
                break;
            case "LF":
                for(NonPitcher player : leftField)
                    System.out.println(player.toString());
                break;
            case "CF":
                for(NonPitcher player : centerField)
                    System.out.println(player.toString());
                break;
            case "RF":
                for(NonPitcher player : rightField)
                    System.out.println(player.toString());
                break;
            default:
                System.out.println("Error\n\n");
                break;
        }
    }

    public Teams getBatter(String playerName) {
        for(NonPitcher player : allNonPitchers) {
            if(playerName.equalsIgnoreCase(player.getName())) {
                return player;
            }
        }
        for(Pitcher player : pitcher) {
            if(playerName.equalsIgnoreCase(player.getName())) {
                return player;
            }
        }
        System.out.println("Player does not exists in database");
        return null;
    }
}
