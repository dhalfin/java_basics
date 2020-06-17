import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {
    public static void main(String[] args) throws IOException {
        int boxCount = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        final int CONTAINER_COUNT_IN_TRUCK = 12;
        final int BOX_COUNT_IN_CONTAINER = 27;

        /*int containerTotalNumber = 0;
        int boxTotalNumber = 0;
        int truckNumber = 0;

        for (; boxTotalNumber <= boxCount; truckNumber++) {
            System.out.println("Truck " + (truckNumber + 1));
            for (int containerNumberInTruck = 0; containerNumberInTruck <= CONTAINER_COUNT_IN_TRUCK && boxTotalNumber <= boxCount;
                 containerNumberInTruck++, containerTotalNumber++) {
                System.out.println("Container " + (containerTotalNumber + 1));
                for (int boxNumberInContainer = 0; boxNumberInContainer <= BOX_COUNT_IN_CONTAINER && boxTotalNumber <= boxCount;
                     boxNumberInContainer++, boxTotalNumber++) {
                    System.out.println("Box " + (boxTotalNumber + 1));
                }
            }
        }

        System.out.printf("Total %d truck(s), %d container(s), %d  box(es)", truckNumber, containerTotalNumber, boxTotalNumber);
        System.out.println();*/

        final int BOX_COUNT_IN_TRUCK = BOX_COUNT_IN_CONTAINER * CONTAINER_COUNT_IN_TRUCK;

        for(int box = 0; box < boxCount; box++) {
            if(box % BOX_COUNT_IN_CONTAINER == 0) {
                if(box % BOX_COUNT_IN_TRUCK == 0) {
                    System.out.println("Truck " + (box / BOX_COUNT_IN_TRUCK + 1));
                }
                System.out.println("Container " + (box / BOX_COUNT_IN_CONTAINER + 1));
            }
            System.out.println("Box " + (box + 1));
        }
        int truckCount = (boxCount + BOX_COUNT_IN_TRUCK - 1)/ BOX_COUNT_IN_TRUCK;
        int containerCount = (boxCount + BOX_COUNT_IN_CONTAINER - 1) / BOX_COUNT_IN_CONTAINER;

        System.out.printf("Total %d truck(s), %d container(s), %d  box(es)", truckCount, containerCount, boxCount);
        System.out.println();
    }
}