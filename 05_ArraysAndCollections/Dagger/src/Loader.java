public class Loader {
    public static void main(String[] args) {
        String symbol = "X";
        int height = 7;
        int width = 7;

        String dagger[][] = new String[width][height];
        for (int i = 0; i < dagger.length; i++) {
            for (int j = 0; j < dagger[i].length; j++) {
                if (i == j || i + j == dagger[i].length - 1) {
                    dagger[i][j] = symbol;
                    System.out.print(dagger[i][j]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
