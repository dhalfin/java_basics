
public class Loader {

    public static final int PATIENT_AMOUNT = 30;
    public static final float MIN_TEMP = (float) 32;
    public static final float MAX_TEMP = (float) 40;
    public static final float MIN_TEMP_HEALTHY_PATIENT = (float) 36.2;
    public static final float MAX_TEMP_HEALTHY_PATIENT = (float) 36.9;

    public static void main(String[] args) {

        float[] temps = new float[PATIENT_AMOUNT];
        System.out.print("Температуры пациентов: ");
        float avg = averageTemperature(temps);
        System.out.print("\n" + "Средняя температура: " + avg);
        int healthyAmount = getHealthyPatientsCount(temps);
        System.out.println("\n" + "Количество здоровых: " + healthyAmount);
    }

    public static float averageTemperature(float[] temperatures) {
        float sum = 0;
        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = (float) (MIN_TEMP + Math.random() * (MAX_TEMP - MIN_TEMP));
            sum = sum + temperatures[i];
            System.out.print(temperatures[i] + " ");
        }
        return (float) Math.round(sum / PATIENT_AMOUNT);
    }

    public static int getHealthyPatientsCount(float[] temperatures) {
        int healthyAmount = 0;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] >= MIN_TEMP_HEALTHY_PATIENT && temperatures[i] < MAX_TEMP_HEALTHY_PATIENT) {
                healthyAmount++;
            }
        }
        return healthyAmount;
    }
}
