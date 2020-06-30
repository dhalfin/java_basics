import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        Set<String> numbers = getNumbers();

        ArrayList<String> arrayList = new ArrayList<>(numbers);
        ArrayList<String> sortedArrayList = new ArrayList<>(numbers);
        Collections.sort(sortedArrayList);
        Collections.binarySearch(sortedArrayList,"A100AA03");
        HashSet<String> hashSet = numbers instanceof HashSet ? (HashSet<String>) numbers : new HashSet<>(numbers);
        TreeSet<String> treeSet = numbers instanceof TreeSet ? (TreeSet<String>) numbers : new TreeSet<>(numbers);

        for (;;) {
            System.out.println("Total = " + numbers.size());
            System.out.println("Пожалуйста, напишите красивый номер Вашего автомобиля:");
            String blatantCarNumber = reader.readLine().trim();
            long start1 = System.nanoTime();
            boolean exists1 = arrayList.contains(blatantCarNumber);
            long finish1 = System.nanoTime();
            //System.out.println(String.format("%b(%fms)", exists1, (finish1 - start1) / 1_000_000.0));
            System.out.println("Поиск перебором: номер найден/не найден, поиск занял " + (finish1 - start1) / 1_000_000.0 + "нс");

            long start2 = System.nanoTime();
            boolean exists2 = sortedArrayList.contains(blatantCarNumber);
            long finish2 = System.nanoTime();
            //System.out.println(String.format("%b(%fms)", exists2, (finish2 - start2) / 1_000_000.0));
            System.out.println("Бинарный поиск: номер найден/не найден, поиск занял " + (finish2 - start2) / 1_000_000.0 + "нс");

            long start3 = System.nanoTime();
            boolean exists3 = hashSet.contains(blatantCarNumber);
            long finish3 = System.nanoTime();
            //System.out.println(String.format("%b(%fms)", exists3, (finish3 - start3) / 1_000_000.0));
            System.out.println("Поиск в HashSet: номер найден/не найден, поиск занял " + (finish3 - start3) / 1_000_000.0 + "нс");

            long start4 = System.nanoTime();
            boolean exists4 = treeSet.contains(blatantCarNumber);
            long finish4 = System.nanoTime();
            //System.out.println(String.format("%b(%fms)", exists4, (finish4 - start4) / 1_000_000.0));
            System.out.println("Поиск в TreeSet: номер найден/не найден, поиск занял " + (finish4 - start4) / 1_000_000.0 + "нс");
        }
    }

    private static Set<String> getNumbers() {
        char[] symbols = {'A', 'H', 'Y', 'T', 'P', 'O', 'M', 'B', 'C', 'X', 'K', 'E'};
        final int NUMBERS_COUNT = 1000, DIGIT_COUNT = 10;
        int[] regions = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 102};
        Set<String> buffer = new HashSet<>();

        for (char symbol : symbols)
            for (int digit = 0; digit < NUMBERS_COUNT; digit++) {
                String number = String.format("%1$c%2$03d%1$c%1$c", symbol, digit);
                buffer.add(number);
            }

        for (char symbol1 : symbols)
            for (char symbol2 : symbols)
                for (char symbol3 : symbols)
                    for (int digit = 0; digit < DIGIT_COUNT; digit++) {
                        String number = String.format("%2$c%1$d%1$d%1$d%3$c%4$c", digit, symbol1, symbol2, symbol3);
                        buffer.add(number);

                        number = String.format("%2$c%1$d00%3$c%4$c", digit, symbol1, symbol2, symbol3);
                        buffer.add(number);
                    }

        Set<String> result = new HashSet<>();
        for (String number : buffer) {
            for (int region : regions) {
                result.add(String.format("%s%02d", number, region));
            }
        }
        return result;
    }
}
