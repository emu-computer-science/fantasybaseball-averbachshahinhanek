package testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DataBase {
    //The Database contain these stats in the following order for Hitters:
    //Last Name, First initial, Position, Team, AB, SB, AVG, OBP, SLG
    //Can be found on mlb website

    ArrayList<NonPitcher> catchers = new ArrayList<>();
    ArrayList<NonPitcher> firstBase = new ArrayList<>();
    ArrayList<NonPitcher> secondBase = new ArrayList<>();
    ArrayList<NonPitcher> thirdBase = new ArrayList<>();
    ArrayList<NonPitcher> SS = new ArrayList<>();
    ArrayList<NonPitcher> leftField = new ArrayList<>();
    ArrayList<NonPitcher> centerField = new ArrayList<>();
    ArrayList<NonPitcher> rightField = new ArrayList<>();

    //These hold all the Non-pitcher and the other holds all the pitchers
    ArrayList<NonPitcher> allNonPitchers = new ArrayList<>();
    ArrayList<Pitcher> pitcher = new ArrayList<>();

    public DataBase() {}

    public void initializePitcher(File database) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(database));
        String data; //Holds contents of a line of the database
        String[] line = new String[10];
        int tempC = 0;
        //To store pitcher data
        while((data = reader.readLine()) != null) {
            line = data.split(" ");

            line[0] = line[0].substring(0,1);
            line[1] = line[1] + ",";
            //Format example: [Last name, first initial, position, team, IP]
            pitcher.add(new Pitcher((line[1] + " " + line[0]), line[2],"P",Double.parseDouble(line[6])));
        }
        reader.close();
    }

    public void initializeBatters(File database) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(database));
        String data; //Holds contents of a line of the database
        String[] line = new String[20];

        //To store pitcher data
        while((data = reader.readLine()) != null) {
            //Splits lines based on white space
            line = data.split(" ");

            //First initial of first name
            line[0] = line[0].substring(0,1);
            //Adds a comma to the last name
            line[1] = line[1] + ",";
            if(line.length - 1 <= 15)
               allNonPitchers.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],0));
            else
                //Format example: [Last name, first initial, position, team, AVG]
                allNonPitchers.add(new NonPitcher((line[1] + " " + line[0]), line[3], line[2], Double.parseDouble(line[16])));

            //line[1] + " " + line[0] is a concatenation of the last name and first initial
            //line[3] is the players position, line[2] is the players team, and either 0 or line[16] is the AVG stat.
            //Other stats haven't been read in yet.
            //AVG is set to 0 if no AVG is found
            switch(line[2]) {
                case "C":
                    if(line.length - 1 <= 15) {
                        catchers.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],0));
                        break;
                    }
                    //Format example: [Last name, first initial, position, team, AVG]
                    catchers.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "1B":
                    if(line.length - 1 <= 15) {
                        firstBase.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],0));
                        break;
                    }
                    //Format example: [Last name, first initial, position, team, AVG]
                    firstBase.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "2B":
                    if(line.length - 1 <= 15) {
                        secondBase.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],0));
                        break;
                    }
                    //Format example: [Last name, first initial, position, team, AVG]
                    secondBase.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "3B":
                    if(line.length - 1 <= 15) {
                        thirdBase.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],0));
                        break;
                    }
                    //Format example: [Last name, first initial, position, team, AVG]
                    thirdBase.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "SS":
                    if(line.length - 1 <= 15) {
                        SS.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],0));
                        break;
                    }
                    //Format example: [Last name, first initial, position, team, AVG]
                    SS.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "LF":
                    if(line.length - 1 <= 15) {
                        leftField.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],0));
                        break;
                    }
                    //Format example: [Last name, first initial, position, team, AVG]
                    leftField.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "CF":
                    if(line.length - 1 <= 15) {
                        centerField.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],0));
                        break;
                    }
                    //Format example: [Last name, first initial, position, team, AVG]
                   centerField.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],Double.parseDouble(line[16])));
                    break;
                case "RF":
                    if(line.length - 1 <= 15) {
                        rightField.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],0));
                        break;
                    }
                    //Format example: [Last name, first initial, position, team, AVG]
                    rightField.add(new NonPitcher((line[1] + " " + line[0]),line[3],line[2],Double.parseDouble(line[16])));
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
                //Prints out all catchers in format below
                for(NonPitcher player : catchers)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, position, team, AVG]
                    System.out.println(player.toString());
                break;
            case "1B":
                //Prints out all first basemen in format below
                for(NonPitcher player : firstBase)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, position, team, AVG]
                    System.out.println(player.toString());
                break;
            case "2B":
                //Prints out all second basemen in format below
                for(NonPitcher player : secondBase)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, position, team, AVG]
                    System.out.println(player.toString());
                break;
            case "3B":
                //Prints out all third basemen in format below
                for(NonPitcher player : thirdBase)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, position, team, AVG]
                    System.out.println(player.toString());
                break;
            case "SS":
                //Prints out all Short Stops in format below
                for(NonPitcher player : SS)
                    System.out.println(player.toString());
                break;
            case "LF":
                //Prints out all left fielders in format below
                for(NonPitcher player : leftField)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, position, team, AVG]
                    System.out.println(player.toString());
                break;
            case "CF":
                //Prints out all center fielders in format below
                for(NonPitcher player : centerField)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, position, team, AVG]
                    System.out.println(player.toString());
                break;
            case "RF":
                //Prints out all right fielders in format below
                for(NonPitcher player : rightField)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, position, team, AVG]
                    System.out.println(player.toString());
                break;
            default:
                //If all cases are invalid, print out an error msg.
                System.out.println("Error\n\n");
                break;
        }
    }
    //Looks for provided player through both large databases and drafts them
    //into provided team.
    public void getPlayer(String name, Team team) {
        for(NonPitcher player : allNonPitchers) {
            if(player.getName().equalsIgnoreCase(name)) {
                if(!team.addPlayer(player)) {
                    return;
                }
                allNonPitchers.remove(player); //Removes him from the draft list
                return;
            }
        }

        for(Pitcher player : pitcher) {
            if(player.getName().equalsIgnoreCase(name)) {
                if(!team.addPlayer(player))
                    return;
                pitcher.remove(player); //Removes player from draft list
                return;
            }
        }

        System.out.println(name + " has already been drafted.");
    }

    public void print() {
        for(NonPitcher i : allNonPitchers) {
            System.out.println(i.toString());
        }
    }

    //Getter Methods
    public ArrayList<NonPitcher> getCatchers() {
        return catchers;
    }

    public ArrayList<NonPitcher> getFirstBase() {
        return firstBase;
    }

    public ArrayList<NonPitcher> getSecondBase() {
        return secondBase;
    }

    public ArrayList<NonPitcher> getThirdBase() {
        return thirdBase;
    }

    public ArrayList<NonPitcher> getSS() {
        return SS;
    }

    public ArrayList<NonPitcher> getLeftField() {
        return leftField;
    }

    public ArrayList<NonPitcher> getCenterField() {
        return centerField;
    }

    public ArrayList<NonPitcher> getRightField() {
        return rightField;
    }

    public ArrayList<NonPitcher> getAllNonPitchers() {
        return allNonPitchers;
    }

    public ArrayList<Pitcher> getPitcher() {
        return pitcher;
    }
}
