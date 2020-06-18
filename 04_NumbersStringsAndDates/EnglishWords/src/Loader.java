import java.util.Arrays;

public class Loader {
    public static void main(String[] args) {
        String text = "Mother's Day: From medieval brawls to greeting cards and flowers!!! " +
                "Though procrastinators often seem almost proud of the habit – there’s even a" +
                " National Procrastination Week in honour of it (it’s supposed to start in early" +
                " March, but it’s often delayed, of course) – there’s overwhelming evidence that " +
                "it’s a bad idea. One 2013 study found that the worst offenders tend to have " +
                "lower salaries, shorter employment durations and are more likely to be jobless " +
                "or under-employed. It’s not even fun: as everyone knows intuitively already, " +
                "procrastinators tend to be more stressed overall, and there’s some evidence that " +
                "the habit could even make you ill.\n" +
                "\n" +
                "In fact, the pastime can be so utterly crippling that it’s been given a new joke" +
                " definition: “Procrastination (noun). The action of ruining your life for no apparent reason.”";

        String[] elements = text.split("[\\s\\\\/()\\[\\]\"-]+");
        System.out.println(Arrays.toString(elements));
        for (String element : elements) {
            element = element.replaceAll("[.,:;!?’”]+$",  "");
            //element = element.replaceAll("$+[“‘]", "");
            if(element.matches("[A-Za-z][a-z]*|[A-Z]+")) {
                System.out.println(element);
            } else {
                String newElement = element.replaceAll("'", "");
                if(newElement.matches("[A-Za-z]+")) //&& newElement.length() < element.length();
                    System.out.println(element + " possibly contraction/concatenation");
            }
        }
    }
}
