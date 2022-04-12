package testing;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataBaseTest
{
DataBase dataBase;
    @Before
    public void setUp() throws Exception
    {
        dataBase = new DataBase("Pitchers.txt", "Batters.txt");
//        dataBase.initializePitcher(new File(getClass().getClassLoader().getResource("Pitchers.txt").getFile()));
//        dataBase.initializeBatters(new File(getClass().getClassLoader().getResource("Batters.txt").getFile()));
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getPlayer()
    {
        //adding NonPitcher players
        //Abreu, J CWS 1B 0.261
        //Guerrero, V TOR 1B 0.311
        Path resourceDirectory = Paths.get("src","test","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();

        System.out.println(absolutePath);

        Assert.assertTrue(absolutePath.endsWith("src/test/resources"));
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