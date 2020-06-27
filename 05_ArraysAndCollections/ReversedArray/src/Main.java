public class Main {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] array = text.split(",?\\s+");

        int n = array.length;
        String changeItem;

        for (int i = 0; i < n/2; i++) {
            changeItem = array[n - i - 1];
            array[n - i - 1] = array[i];
            array[i] = changeItem;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
