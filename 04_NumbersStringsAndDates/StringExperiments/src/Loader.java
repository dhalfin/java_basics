
public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        String earned = "заработал";
        String rubles = "рубл";
        String line = " - ";

        int startFirstValue = text.indexOf(earned);
        startFirstValue = text.indexOf(" ", startFirstValue + earned.length());
        int endFirstValue = text.indexOf(rubles);
        String firstValue = text.substring(startFirstValue, endFirstValue).trim();

        int startSecondValue = text.indexOf(line) + line.length();
        int endSecondValue = text.indexOf(rubles, endFirstValue + rubles.length());
        String secondValue = text.substring(startSecondValue, endSecondValue).trim();

        int startLastValue = text.lastIndexOf(line) + line.length();
        int endLastValue = text.lastIndexOf(rubles);
        String lastValue = text.substring(startLastValue, endLastValue).trim();

        int firstAmountParsed = Integer.parseInt(firstValue);
        int secondAmountParsed = Integer.parseInt(secondValue);
        int lastAmountParsed = Integer.parseInt(lastValue);

        int totalAmount = firstAmountParsed + secondAmountParsed + lastAmountParsed;
        System.out.println("Total amount = " + totalAmount);
    }
}