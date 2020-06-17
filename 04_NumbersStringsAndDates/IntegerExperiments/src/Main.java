import java.util.zip.DeflaterOutputStream;

public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        Byte d1 = Byte.MIN_VALUE;
        Byte d2 = Byte.MAX_VALUE;
        Integer d3 = Integer.MIN_VALUE;
        Integer d4 = Integer.MAX_VALUE;
        Short d5 = Short.MIN_VALUE;
        Short d6 = Short.MAX_VALUE;
        Long d7 = Long.MIN_VALUE;
        Long d8 = Long.MAX_VALUE;
        Float d9 = -Float.MAX_VALUE;
        Float d10 = Float.MAX_VALUE;
        Double d11 = -Double.MAX_VALUE;
        Double d12 = Double.MAX_VALUE;

        System.out.print("Byte: " + d1 + " " + d2 + "\n"
                + "Integer: " + d3 + " " + d4 + "\n"
                + "Short: " + d5 + " " + d6 + "\n"
                + "Long: " + d7 + " " + d8 + "\n"
                + "Float: "+ d9 + " " + d10 + "\n"
                + "Double: "+ d11 + " " + d12);
    }

    public Integer sumDigits(Integer number)
    {
        String digits = Integer.toString(number);
        Integer sum = 0;
        for (int i = 0; i <=digits.length() - 1; i++) {
            //sum += Integer.parseInt(String.valueOf(digits.charAt(i)));
            if (Character.isDigit(digits.charAt(i))) {
                Integer y = Character.getNumericValue(digits.charAt(i));
                sum += y;
            }
        }
        return sum;
    }
}
