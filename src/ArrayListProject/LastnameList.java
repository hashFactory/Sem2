package ArrayListProject;

import java.util.ArrayList;

public class LastnameList
{
    public static void main(String [] args)
    {
        ArrayList<String> lastNames = new ArrayList<String>();
        lastNames.add("Oppenheimer Rodriguez");
        lastNames.add("Charpentier");
        lastNames.add("Kim");

        for (String lastname: lastNames)
        {
            System.out.println(lastname);
        }
    }
}
