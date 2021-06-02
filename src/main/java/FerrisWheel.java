import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class FerrisWheel {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(bufferedReader.readLine());
        Integer numOfChildren = Integer.parseInt(st1.nextToken());
        Integer maxWeight = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(bufferedReader.readLine());

        List<Integer> childrenWeights = new ArrayList<>();
        Integer counter = 0;
        while (counter < numOfChildren && st2.hasMoreTokens()) {
            childrenWeights.add(Integer.parseInt(st2.nextToken()));
            counter++;
        }

        Collections.sort(childrenWeights);

        int low = 0, high = childrenWeights.size() - 1;

        int result = 0;
        while (high > low) {
            if (childrenWeights.get(high) + childrenWeights.get(low) > maxWeight) {
                high--;
            } else {
                high--;
                low++;
            }
            result++;
        }
        if (high == low) {
            result++;
        }
        System.out.println(result);
    }
}