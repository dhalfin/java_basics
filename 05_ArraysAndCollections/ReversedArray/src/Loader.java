public class Loader {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] array = text.split(",?\\s+");

       for (int i = array.length - 1; i >= 0; i--) {
           System.out.println(array[i] + " ");
       }
    }
}
