package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import testing.DataBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DataBaseTest
{
DataBase dataBase;
    ArrayList<Pitcher> pitcher;
    @Before
    public void setUp() throws Exception
    {
        dataBase = new DataBase("Pitchers.txt", "Batters.txt");
        pitcher = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception
    {
    }

@Test
public void getInitializePitcher()
{
    dataBase.setPitchersDatabase("Pitchers.txt");
    try (BufferedReader reader = new BufferedReader(new FileReader(dataBase.getPitchersDatabase())))
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

    @Test
    public void getPlayer()
    {

        //check if the file is read correctly
//        assertTrue(dataBase.initializeBatters());

        //changing the file name to see if it it fails

//        assertFalse(dataBase.initializePitcher(pitchersDatabase));
//        assertFalse(dataBase.initializeBatters(battersDatabase));

        //check if file not fo
        //adding NonPitcher players
        //Abreu, J CWS 1B 0.261
        //Guerrero, V TOR 1B 0.311

        //adding pitcher

        //adding

    }

    @Test
    public void getCatchers()
    {
    }

    @Test
    public void getFirstBase()
    {
    }

    @Test
    public void getSecondBase()
    {
    }

    @Test
    public void getThirdBase()
    {
    }

    @Test
    public void getSS()
    {
    }

    @Test
    public void getLeftField()
    {
    }

    @Test
    public void getCenterField()
    {
    }

    @Test
    public void getRightField()
    {
    }

    @Test
    public void getAllNonPitchers()
    {
    }

    @Test
    public void getPitcher()
    {
    }
}