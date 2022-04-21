package testing;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DataBaseTest
{
DataBase dataBase;
    ArrayList<Pitcher> pitcher;
    private Path workingDir;
    @Before
    public void setUp() throws Exception
    {
        dataBase = new DataBase("/Pitchers.txt", "Batters.txt");
        pitcher = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Before
    public void init() {
        this.workingDir = Path.of("", "src/test/resources");
    }



    @Test
    public void testReadFileWithClassLoader(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(dataBase.getPitchersDatabase()).getFile());
        Assert.assertTrue(file.exists());

    }

@Test
public void getInitializePitcher() throws IOException {
    //would not allow to read from file
    Path file = this.workingDir.resolve(dataBase.getPitchersDatabase());
    String content = Files.readString(file);
    assertThat(content, is("duke"));


    try (BufferedReader reader = new BufferedReader(new FileReader("absolutePath")))
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
    }

    @Test
    public void getCatchers()
    {
        //dataBase.catchers.add()
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