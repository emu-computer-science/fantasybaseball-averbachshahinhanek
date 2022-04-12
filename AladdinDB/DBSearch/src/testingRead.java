import java.io.FileReader;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class testingRead
{
    public static void main(String[] args)
    {


        CSVReader reader = null;
        try
        {
            CSVIterator iterator = new CSVIterator(new CSVReader(new FileReader("src/battingDb.csv")));
            for (; iterator.hasNext(); ) {
                String[] nextLine = iterator.next();
                // nextLine[] is an array of values from the line


                String[] names = nextLine[1].split(" ");
                String lastNameInitial = names[1].substring(0,1);
                String firstName = names[0];

                String name = firstName+", "+lastNameInitial;

                if ("Jordan".equals(firstName)){ //<------- Here is where I put the Player I want to search for
                    Map<String, String> playerReturn = new HashMap<>();
                    playerReturn.put("Name", name);
                    playerReturn.put("Player Age", nextLine[2]);

                    //System.out.println(nextLine[1]+nextLine[2]+nextLine[3]);
                }
            }
           
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}