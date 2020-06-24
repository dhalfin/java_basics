import java.text.DecimalFormat;

public class Loader {

    public static final int PATIENT_AMOUNT = 30;
    public static final float MIN_TEMP = (float) 32;
    public static final float MAX_TEMP = (float) 40;
    public static final float MIN_TEMP_HEALTHY_PATIENT = (float) 36.2;
    public static final float MAX_TEMP_HEALTHY_PATIENT = (float) 36.9;

    public static void main(String[] args) {
        float sum = 0;
        float[] temps = new float[30];
        int healthyAmount = 0;
        System.out.print("Температуры пациентов: ");
        for (int i = 0; i < temps.length; i++) {
            temps[i] = (float) (MIN_TEMP + Math.random() * (MAX_TEMP - MIN_TEMP));
            //temps[i] = (float) Math.round(temps[i] * 100 / 100.0);
             // String formattedFl = new DecimalFormat("#0.00").format(temps[i]);
              //float twoDigitsF = Float.valueOf(formattedFl);
            sum = sum + temps[i];
            //System.out.print(String.format("%.2f", temps[i]));
            System.out.print(temps[i] + " ");
//            sum = sum + twoDigitsF;
//            System.out.println(twoDigitsF + " ");
            if (temps[i] > MIN_TEMP_HEALTHY_PATIENT && temps[i] < MAX_TEMP_HEALTHY_PATIENT) {
                healthyAmount++;
            }
        }
        float avg = (float) Math.round(sum / PATIENT_AMOUNT);
        System.out.print("\n" + "Средняя температура: " + avg);
        System.out.println("\n" + "Количество здоровых: " + healthyAmount);
    }
}
