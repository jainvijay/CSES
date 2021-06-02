
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DistinctNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Integer length = in.nextInt();

        Integer counter = 0;
        Set<Integer> distinctValues = new TreeSet<>();
        while(counter < length && in.hasNext()) {
            int a = in.nextInt();
            distinctValues.add(a);
            counter++;
        }
        System.out.println(distinctValues.size());
    }

}
