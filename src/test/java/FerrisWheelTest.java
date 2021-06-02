import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.TestCase;

public class FerrisWheelTest extends TestCase {

    public void testFindLesser() {
        String[] s = "9 8 8 9 10 8 5 8 7 10 13".split(" ");
        List<Integer> weights = new ArrayList<>();
        for (String s1 : s) {
            weights.add(Integer.parseInt(s1));
        }
//        List<Long> weights = Arrays.asList(5l,9l, 6l, 5l, 8l, 9l, 10l,6l, 5l, 6l);
//        List<Long> weights2 = Arrays.asList(1l,1l,1l,1l,1l,1l,1l,1l,1l,1l);

        Collections.sort(weights);
        System.out.println(weights);
        FerrisWheel ferrisWheel = new FerrisWheel();

    }
}