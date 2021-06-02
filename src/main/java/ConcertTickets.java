import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(bufferedReader.readLine());
        Integer numOfTickets = Integer.parseInt(st1.nextToken());
        Integer numOfCustomer = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(bufferedReader.readLine());

        List<Integer> ticketPrices = new ArrayList<>();
        while (st2.hasMoreTokens()) {
            ticketPrices.add(Integer.parseInt(st2.nextToken()));
        }

        StringTokenizer st3 = new StringTokenizer(bufferedReader.readLine());

        List<Integer> maxPriceToPay = new ArrayList<>();
        while (st3.hasMoreTokens()) {
            maxPriceToPay.add(Integer.parseInt(st3.nextToken()));
        }

        Collections.sort(ticketPrices);

        for (Integer maxPrice : maxPriceToPay) {
            if(ticketPrices.get(0) > maxPrice) {
                System.out.println(-1);
            }
            else {
                int lesser = findLesser(ticketPrices, maxPrice);
                System.out.println(ticketPrices.get(lesser));
                ticketPrices.remove(lesser);
            }
        }
    }

    public static int findLesser(List<Integer> prices, Integer maxPrice) {
        int low = 0, high = prices.size() - 1;
        while (high >= low) {
            int middle = low + (high - low + 1)/2;
            if (prices.get(middle) > maxPrice) {
                high = middle - 1;
            } else if (prices.get(middle) < maxPrice) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return low;
    }
}
