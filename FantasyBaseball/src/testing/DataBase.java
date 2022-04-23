package testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
    //The Database contain these stats in the following order for Hitters:
    //Last Name, First initial, Position, Team, AB, SB, AVG, OBP, SLG
    //Can be found on mlb website
    private  String pitchersDatabase;
    private  String battersDatabase;

    ArrayList<NonPitcher> catchers = new ArrayList<>();
    ArrayList<NonPitcher> firstBase = new ArrayList<>();
    ArrayList<NonPitcher> secondBase = new ArrayList<>();
    ArrayList<NonPitcher> thirdBase = new ArrayList<>();
    ArrayList<NonPitcher> shortStop = new ArrayList<>();
    ArrayList<NonPitcher> leftField = new ArrayList<>();
    ArrayList<NonPitcher> centerField = new ArrayList<>();
    ArrayList<NonPitcher> rightField = new ArrayList<>();

    //These hold all the Non-pitcher and the other holds all the pitchers
    ArrayList<NonPitcher> allNonPitchers = new ArrayList<>(); //TODO SAVE THIS ARRAY FOR THE SAVE COMMAND AND WHEN RESTORING, RESTORE INTO THIS ARRAY
    ArrayList<Pitcher> pitcher = new ArrayList<>(); //TODO SAVE THIS ARRAY FOR THE SAVE COMMAND AND WHEN RESTORING, RESTORE INTO THIS ARRAY

    ArrayList<NonPitcher> draftedNPs = new ArrayList<>(); //TODO SAVE THIS ARRAY FOR THE SAVE COMMAND AND WHEN RESTORING, RESTORE INTO THIS ARRAY
    ArrayList<Pitcher> draftedP = new ArrayList<>(); //TODO SAVE THIS ARRAY FOR THE SAVE COMMAND AND WHEN RESTORING, RESTORE INTO THIS ARRAY

    public DataBase(String pitchersDatabase, String battersDatabase)
    {
        this.pitchersDatabase = pitchersDatabase;
        this.battersDatabase = battersDatabase;
        initializePitcher();
        initializeBatters();
    }

    private void initializePitcher() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getPitchersDatabase())))
        {
            String data; //Holds contents of a line of the database
            String[] line = new String[9];
            int tempC = 0;
            //To store pitcher data
            reader.readLine(); //Reads first line of the database
            while ((data = reader.readLine()) != null)
            {
                line = data.split(" ");

                    line[0] = line[0].substring(0, 1);
                    line[1] = line[1] + ",";
                    //Format example: [Last name, first initial, team, position, IP]
                    pitcher.add(new Pitcher((line[1] + " " + line[0]), line[2], "P", Double.parseDouble(line[3]),
                            Double.parseDouble(line[4]), Double.parseDouble(line[5]), Double.parseDouble(line[6]),
                            Double.parseDouble(line[7]), Double.parseDouble(line[8])));
                }
            } catch (IOException e)
            {
                System.out.println("Error reading the file");
            }

    }

    //pubic for junit testing
    private void initializeBatters()  {
        try (BufferedReader reader = new BufferedReader(new FileReader(getBattersDatabase())))
        {
            String data; //Holds contents of a line of the database
            String[] line = new String[11];

                //To store pitcher data
                reader.readLine(); //Reads first line of database
                while ((data = reader.readLine()) != null)
                {
                    //Splits lines based on white space
                    line = data.split(" ");

                    //First initial of first name
                    line[0] = line[0].substring(0, 1);
                    //Adds a comma to the last name
                    line[1] = line[1] + ",";
                    //Player: NonPitcher: LastName FirstName Team Position AVG OBP AB SLG SB R H HR
                    nonPitcher(line, allNonPitchers);

                    //Player: NonPitcher: LastName FirstName Team Position AVG OBP AB SLG SB R H HR
                    switch (line[2])
                    {
                        case "C":
                            nonPitcher(line, catchers);
                            break;
                        case "1B":
                            nonPitcher(line, firstBase);
                            break;
                        case "2B":
                            nonPitcher(line, secondBase);
                            break;
                        case "3B":
                            nonPitcher(line, thirdBase);
                            break;
                        case "SS": //none pitcher?
                            nonPitcher(line, shortStop);
                            break;
                        case "LF":
                            nonPitcher(line, leftField);
                            break;
                        case "CF":
                            nonPitcher(line, centerField);
                            break;
                        case "RF":
                            nonPitcher(line, rightField);
                            break;
                        default:
                            break;
                    }
                }
                reader.close();
            } catch (IOException e)
            {
                System.out.println("Error reading the file");
            }
    }

    //this method will handle the repeated code we had before
    private void nonPitcher(String[] line, ArrayList<NonPitcher> catchers)
    {
        catchers.add(new NonPitcher((line[1] + " " + line[0]), line[3], line[2], Double.parseDouble(line[9]),
                Double.parseDouble(line[10]), Double.parseDouble(line[4]), Double.parseDouble(line[11]),
                Double.parseDouble(line[8]), Double.parseDouble(line[5]), Double.parseDouble(line[6]),
                Double.parseDouble(line[7])));
    }



    //Looks for provided player through both large databases and drafts them
    //into provided team.
    //public void getPlayer(String name, Team team) {
    public void getPlayer(String name, Team team) {
        for(NonPitcher player : allNonPitchers) {
            if(player.getName().equalsIgnoreCase(name)) {
                //if(draftedNPs.contains(player)) {
                if(draftedNPs.contains(name)) {//small fix here.
                    System.out.println(player.getName() + " has already been drafted.\n");
                    //return "NonPitcher player Already Drafted";
                }

                team.addPlayer(player);
                draftedNPs.add(player);
                //System.out.println("NonPitcher " +name+" is added.");
                return;
            }
        }

        for(Pitcher player : pitcher) {
            if(player.getName().equalsIgnoreCase(name)) {
                if(draftedP.contains(name)) {
                    System.out.println(player.getName() + " has already been drafted.\n");
                    return;
                }
                
                team.addPlayer(player);
                draftedP.add(player);
                System.out.println("Pitcher " +name+" is added.");
                return;
                //return "Pitcher player is added" ;
            }
        }
        System.out.println("Could not locate: " + name + " in the MLB database.\n");
        return;
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

    public ArrayList<NonPitcher> getShortStop() {
        return shortStop;
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

    public String getPitchersDatabase()
    {
        return pitchersDatabase;
    }

    public String getBattersDatabase()
    {
        return battersDatabase;
    }

    public void setPitchersDatabase(String pitchersDatabase)
    {
        this.pitchersDatabase = pitchersDatabase;
    }

    public void setBattersDatabase(String battersDatabase)
    {
        this.battersDatabase = battersDatabase;
    }

    public void display(String position) {
        switch(position) {
            case "C":
                //Prints out all catchers in format below
                for(NonPitcher player : catchers)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, team, position, AVG]
                    System.out.println(player.toString());
                break;
            case "1B":
                //Prints out all first basemen in format below
                for(NonPitcher player : firstBase)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, team, position, AVG]
                    System.out.println(player.toString());
                break;
            case "2B":
                //Prints out all second basemen in format below
                for(NonPitcher player : secondBase)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, team, position, AVG]
                    System.out.println(player.toString());
                break;
            case "3B":
                //Prints out all third basemen in format below
                for(NonPitcher player : thirdBase)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, team, position, AVG]
                    System.out.println(player.toString());
                break;
            case "SS":
                //Prints out all Short Stops in format below
                for(NonPitcher player : shortStop)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, team, position, AVG]
                    System.out.println(player.toString());
                break;
            case "LF":
                //Prints out all left fielders in format below
                for(NonPitcher player : leftField)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, team, position, AVG]
                    System.out.println(player.toString());
                break;
            case "CF":
                //Prints out all center fielders in format below
                for(NonPitcher player : centerField)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, team, position, AVG]
                    System.out.println(player.toString());
                break;
            case "RF":
                //Prints out all right fielders in format below
                for(NonPitcher player : rightField)
                    //Prints out player in the form of a non pitcher: Format example: [Last name, first initial, team, position, AVG]
                    System.out.println(player.toString());
                break;
            default:
                //If all cases are invalid, print out an error msg.
                System.out.println("Error\n\n");
                break;
        }
    }
}
