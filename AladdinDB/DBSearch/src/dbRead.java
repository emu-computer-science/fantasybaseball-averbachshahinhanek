import javax.xml.namespace.QName;
import java.io.*;
import java.util.Scanner;
public class dbRead
{
    static String getPlayer(String name){
        System.out.println(name);
        return name;
    }
    public static void main(String[] args) throws Exception
    {
        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("src/battingDb.csv"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(" "+sc.next());  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner

        String name = "Ryan";

        getPlayer(name);


    }
}