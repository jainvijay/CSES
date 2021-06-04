import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ConcertTickets {

    public static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.value == o.value) {
                return o.index - this.index;
            } else {
                return this.value - o.value;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in));

        String[] st1 = bufferedReader.readLine().split(" ");
        Integer numOfTickets = Integer.parseInt(st1[0]);
        Integer numOfCustomer = Integer.parseInt(st1[1]);
        String[] st2 = bufferedReader.readLine().split(" ");
        TreeSet<Pair> ticketPrices = new TreeSet<>();
        Integer counter = 0;
        for (String s2 : st2) {
            if (counter > numOfTickets) {
                break;
            }
            ticketPrices.add(new Pair(Integer.parseInt(s2), counter));
            counter++;
        }

        String[] st3 = bufferedReader.readLine().split(" ");

        counter = 0;
        List<Integer> maxPriceToPay = new ArrayList<>();
        for (String s3 : st3) {
            if (counter > numOfCustomer) {
                break;
            }
            maxPriceToPay.add(Integer.parseInt(s3));
            counter++;
        }

        OutputStream out = new BufferedOutputStream(System.out);

        for (int i = 0; i < maxPriceToPay.size(); i++) {
            Pair pair = ticketPrices.floor(new Pair(maxPriceToPay.get(i), 0));
            if (pair != null) {
                out.write((pair.value + "\n").getBytes());
                ticketPrices.remove(pair);
            } else {
                out.write((-1 + "\n").getBytes());
            }

        }
        out.flush();
    }


}
