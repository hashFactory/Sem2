import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AMC12b_short
{
    public static void main(String [] args)
    {
        ArrayList<Integer> scores = new ArrayList<>(Stream.of(96, 92, 91, 97, 94, 100, 95).collect(Collectors.toList()));
        //ArrayList<Integer> scores = new ArrayList<>(Stream.of(91, 93, 97, 96, 94, 100, 95).collect(Collectors.toList()));

        for (int i = 0, sum = 0; i < scores.size(); i++)
        {
            System.out.println(scores.get(i));
            if ((sum += scores.get(i)) % (i + 1) == 0 && (new HashSet<>(scores)).size() == scores.size())
                System.out.println("Scores up to " + (i + 1) + " work");
            else
                System.out.println("Scores up to " + (i + 1) + " do not work");
        }
    }
}
