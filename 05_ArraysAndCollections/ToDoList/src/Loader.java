import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    private final static Pattern COMMAND_PATTERN = Pattern.compile("(?<commandType>ADD|LIST|EDIT|DELETE)\\s*(?<dealNo>\\d*)\\s*(?<text>.*)");
    private static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (;;) {
            System.out.println("Пожалуйста, введите одну из команд для списка дел (LIST, ADD, EDIT, DELETE) и задачу:  ");
            String command = reader.readLine().trim();
            Matcher matcher = COMMAND_PATTERN.matcher(command);
            if (matcher.find()) {
                String commandType = matcher.group("commandType");
                String index = matcher.group("dealNo");
                if(index.equals("")) {
                    index = String.valueOf(todoList.size());
                }
                int intIndex = Integer.parseInt(index);
                String text = matcher.group("text");

                if (commandType.equals("LIST")) {
                   list();
                } else if (commandType.equals("ADD")) {
                   add(text);
                } else if (commandType.equals("ADD") && intIndex >= 0) {
                    addDealNoAndText(intIndex, text);
                } else if (commandType.equals("ADD") && (todoList.isEmpty() || intIndex < 0 && intIndex > todoList.size())) {
                    checkList();
                } else if (commandType.equals("EDIT") && (!todoList.isEmpty() || intIndex >= 0 && intIndex < todoList.size())) {
                    addDealNoAndText(intIndex, text);
                } else if (commandType.equals("DELETE") && (!todoList.isEmpty() || intIndex >= 0 && intIndex < todoList.size())) {
                    deleteDealNo(intIndex);
                }
            }
        }
    }
    private static void list() {
        for (String name : todoList) {
            System.out.println(todoList.indexOf(name) + " " + name);
        }
    }

    private static void add(String text) {
        todoList.add(text);
    }

    private static void addDealNoAndText(int intIndex, String text) {
        todoList.add(intIndex, text);
    }

    private static void checkList() {
        System.out.println("Введите положительный номер задачи и до " + todoList.size());
    }

    private static void deleteDealNo(int intIndex) {
        todoList.remove(intIndex);
    }
}


//public class Loader {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String> todoList = new ArrayList<>();
//
//        for (;;) {
//            System.out.println("Пожалуйста, введите одну из команд для списка дел (LIST, ADD, EDIT, DELETE): ");
//            String command = reader.readLine().trim();
//            //Pattern COMMAND_PATTERN = Pattern.compile("(?<commandType>ADD|LIST|EDIT|DELETE)\\s*(?<dealNo>\\d*)\\s*(?<text>.*)");
//            //Matcher matcher = COMMAND_PATTERN.matcher(command);
//
//            String commandType = extractCommand(command);
//            String index = extractDealNo(command);
//            int intIndex = Integer.parseInt(index);
//            String text = extractText(command);
//
//            if (commandType.equals("LIST")) {
//                for (String name : todoList) {
//                    System.out.println(name);
//                }
//            } else if (commandType.equals("ADD")){
//                todoList.add(text);
//            } else if (commandType.equals("ADD") && (todoList.isEmpty() || intIndex >= 0 && intIndex < todoList.size())) {
//               todoList.add(intIndex, text);
//            } else if (commandType.equals("ADD") && (todoList.isEmpty() || intIndex < 0 && intIndex > todoList.size())) {
//                System.out.println("Введите положительный номер задачи и до " + todoList.size());
//            } else if (commandType.equals("EDIT") && (!todoList.isEmpty() || intIndex >= 0 && intIndex < todoList.size())) {
//                todoList.add(intIndex, text);
//            } else if (commandType.equals("DELETE") && (!todoList.isEmpty() || intIndex >= 0 && intIndex < todoList.size())) {
//                todoList.remove(intIndex);
//            } else if (commandType == null) {
//                System.out.println("Неверный ввод данных, введите команду");
//            }
//
//        }
//        }
//
//        private final static Pattern COMMAND_PATTERN = Pattern.compile("(?<commandType>ADD|LIST|EDIT|DELETE)\\s*(?<dealNo>\\d*)\\s*(?<text>.*)");
//        public static String extractCommand(String order) {
//         Matcher matcher = COMMAND_PATTERN.matcher(order);
//            if (matcher.find()) {
//                String commandType = matcher.group("commandType");
//                return commandType;
//            } else {
//                return null;
//            }
//        }
//
//        public static String extractDealNo(String order) {
//            Matcher matcher = COMMAND_PATTERN.matcher(order);
//            if (matcher.find()) {
//                String index = matcher.group("dealNo");
//                return index;
//            } else {
//                return null;
//            }
//        }
//
//        public static String extractText(String order) {
//            Matcher matcher = COMMAND_PATTERN.matcher(order);
//            if (matcher.find()) {
//                String text = matcher.group("text");
//                return text;
//            } else {
//                return null;
//            }
//        }
//    }

//        private final static Pattern COMMAND_PATTERN = Pattern.compile("(?<commandType>ADD|LIST|EDIT|DELETE)\\s*(?<dealNo>\\d*)\\s*(?<text>.*)");
//
//        public static ArrayList<String> arrayProducer(String command) {
//            Matcher matcher = COMMAND_PATTERN.matcher(command);
//            String commandType = matcher.group("commandType");
//            String index = matcher.group("dealNo");
//
//            for(;;) {
//            System.out.println("Please, type new task in the list: ");
//            String order = command.readLine().trim();
//            if(command.equals("LIST")) {
//                for(String name : todoList) {
//                    System.out.println(todoList.indexOf(name) + name);
//                }
//            } else if
//
//            return
//        }

//        String str = "";
//        char s = ' ';
//        for(;;) {
//            System.out.println("Please, type new task in the list: ");
//            String command = reader.readLine().trim();
//            if(command.equals("LIST")) {
//                for(String name : todoList) {
//                    System.out.println(todoList.indexOf(name) + name);
//                }
//            } else if (command.startsWith("ADD")) {
//                str = command.substring(3, command.length());
//                todoList.add(str);
//            } else if (command.startsWith("ADD") &&
//                    command.charAt(4) == areOnlyDigits(command.charAt(4)) &&) {
//
//            }
//        }


//    private static boolean areOnlyDigits(String s) {
//        return s.matches("[\\d]+");
//    }
