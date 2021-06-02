import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistinctNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s1 = in.readLine();
        List<Integer> values = new ArrayList<>();
        String[] s2 = in.readLine().split(" ");
        for (String s : s2) {
            values.add(Integer.parseInt(s));
        }

        Collections.sort(values);

        /*1,2,3*/
        int result = 1, i = 1;
        while (i < values.size()) {
            if(!values.get(i - 1).equals(values.get(i))) {
                result++;
            }
            i++;
        }
        System.out.println(result);
    }

}
