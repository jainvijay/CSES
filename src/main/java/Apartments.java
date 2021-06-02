import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Apartments {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(bufferedReader.readLine());

        Integer numOfApplicants = Integer.parseInt(st1.nextToken());
        Integer numOfApartments = Integer.parseInt(st1.nextToken());
        int acceptableDifference = Integer.parseInt(st1.nextToken());

        String[] st2 = bufferedReader.readLine().split(" ");

        List<Integer> applicantList = new LinkedList<>();
        for (String s : st2) {
            applicantList.add(Integer.parseInt(s));
        }
//        System.out.println("Input loop 1 completed ");

        String[] st3 = bufferedReader.readLine().split(" ");

        List<Integer> apartmentList = new LinkedList<>();
        for (String s : st3) {
            apartmentList.add(Integer.parseInt(s));
        }
//        System.out.println("Input loop 2 completed ");

        Collections.sort(applicantList);
        Collections.sort(apartmentList);

//        System.out.println("Input sort completed ");

        Iterator<Integer> applicationIterator = applicantList.iterator();
        Iterator<Integer> apartmentIterator = apartmentList.iterator();
        /*
         * a1, a2
         * b1
         * */

        /*
         * 3 1 1
         * 133232 2323232 323233
         * 1
         * */
        Integer applicant = applicationIterator.next();
        Integer apartment = apartmentIterator.next();

        Integer result = 0;

        /*
         * 1 3 0
         * 1 2
         * 12 13 14
         * */
        while (applicationIterator.hasNext() || apartmentIterator.hasNext()) {
            if (apartment < applicant - acceptableDifference) {
                if (apartmentIterator.hasNext()) {
                    apartment = apartmentIterator.next();
                    continue;
                } else {
                    break;
                }
            } else if (apartment > applicant + acceptableDifference) {
                if (applicationIterator.hasNext()) {
                    applicant = applicationIterator.next();
                    continue;
                } else {
                    break;
                }
            }

            if(withinRange(apartment, applicant, acceptableDifference)) {
                result++;
                if (applicationIterator.hasNext() && apartmentIterator.hasNext()) {
                    applicant = applicationIterator.next();
                    apartment = apartmentIterator.next();
                } else {
                    break;
                }
            }
        }


        if (!(applicationIterator.hasNext() || apartmentIterator.hasNext()) &&
            withinRange(apartment, applicant, acceptableDifference)) {
            result++;
        }

        System.out.println(result);

    }

    public static boolean withinRange(Integer apartment, Integer applicant, Integer acceptableDifference) {
        return (apartment >= applicant - acceptableDifference) && (apartment <= applicant + acceptableDifference);
    }
}
