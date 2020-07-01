import java.util.*;
import java.util.regex.Pattern;

public class Loader {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("[A-Z][a-z]* [A-Z][a-z]*");

    public static boolean isPhone(String string) { return PHONE_PATTERN.matcher(string).matches(); }

    public static boolean isName(String string) {
        return NAME_PATTERN.matcher(string).matches() && !isList(string);
    }

    public static boolean isList(String string) {
        return string.equals("LIST");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();

        for (; ; ) {
            System.out.println("Please, input a command: ");
            String command = scanner.nextLine();
            command.replaceAll("[^0-9]+","");
            String temp = command.replaceAll("[()\\-\\s]", "");

            if (isList(command)) {
                Collection<Map.Entry<String, String>> sorted = sortByValueAsSet(phoneBook);
                for (Map.Entry<String, String> entry : sorted) {
                    System.out.println(entry.getValue() + " has the number " + entry.getKey());
                }
            } else if (isPhone(temp)) {
                normalizationOfNumber(temp);
                if (phoneBook.containsKey(temp)) {
                    System.out.println("It is a number of " + phoneBook.get(temp));
                } else {
                    System.out.println("Please, input a name for the number " + temp);
                    String name = scanner.nextLine();
                    if (isName(name)) {
                        System.out.println("Thank you!");
                        phoneBook.put(temp, name);
                    } else {
                        System.out.println("Invalid name. Command canceled.");
                    }
                }
            } else if (isName(command)) {

                List<String> numbers = getKeysForValue(phoneBook, command);
                if (!numbers.isEmpty()) {
                    for (String number : numbers) {
                        System.out.println(command + " has the number " + number);
                    }
                } else {
                    System.out.println("Nothing found");
                    System.out.println("Please, input a number for the name " + command);
                    String number = scanner.nextLine();
                    String rightForm = number.replaceAll("[()\\-\\s]", "");
                    normalizationOfNumber(rightForm);
                    if (!isPhone(rightForm)) {
                        System.out.println("Invalid name. Command canceled.");
                    } else if (phoneBook.containsKey(rightForm)) {
                        System.out.println("Number is occupied. Command canceled.");
                    } else {
                        System.out.println("Thank you!");
                        phoneBook.put(rightForm, command);
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    public static String normalizationOfNumber(String number) {
        int range = number.length();
            if (range >= 10) {
                number = number.substring(range - 10);
                number = "+7" + number;
            }
            return number;
    }

    public static List<String> getKeysForValue(Map<String, String> map, String value) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), value)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static List<Map.Entry<String, String>> sortByValueAsList(Map<String, String> map) {
        List<Map.Entry<String, String>> result = new ArrayList<>(map.entrySet());
        result.sort(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> first, Map.Entry<String, String> second) {
                int valueChecking = first.getValue().compareTo(second.getValue());
                if (valueChecking == 0)
                    return first.getKey().compareTo(second.getKey());
                else
                    return valueChecking;
            }
        });
        return result;
    }

    public static TreeSet<Map.Entry<String, String>> sortByValueAsSet(Map<String, String> map) {
        TreeSet<Map.Entry<String, String>> result = new TreeSet<>(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> first, Map.Entry<String, String> second) {
                int valueComparison = first.getValue().compareTo(second.getValue());
                if (valueComparison == 0)
                    return first.getKey().compareTo(second.getKey());
                else
                    return valueComparison;
            }
        });
        result.addAll(map.entrySet());
        return result;
    }
}
