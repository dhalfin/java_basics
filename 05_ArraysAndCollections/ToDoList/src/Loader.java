import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> todoList = new ArrayList<>();

        for (;;) {
            System.out.println("Пожалуйста, введите Вашу задачу: ");
            String command = reader.readLine().trim();
            Pattern COMMAND_PATTERN = Pattern.compile("(?<commandType>ADD|LIST|EDIT|DELETE)\\s*(?<dealNo>\\d*)\\s*(?<text>.*)");
            Matcher matcher = COMMAND_PATTERN.matcher(command);
            String commandType = matcher.group("commandType");
            String index = matcher.group("dealNo");
            int intIndex = Integer.parseInt(index);
            String text = matcher.group("text");

            if (commandType.equals("LIST")) {
                for (String name : todoList) {
                    System.out.println(name);
                }
            } else if (commandType.equals("ADD")){
                todoList.add(text);
            } else if (commandType.equals("ADD") && (todoList.isEmpty() || intIndex >= 0 && intIndex < todoList.size())) {
               todoList.add(intIndex, text);
            } else if (commandType.equals("ADD") && (todoList.isEmpty() || intIndex < 0 && intIndex > todoList.size())) {
                System.out.println("Введите положительный номер задачи и до " + todoList.size());
            } else if (commandType.equals("EDIT") && (!todoList.isEmpty() || intIndex >= 0 && intIndex < todoList.size())) {
                todoList.add(intIndex, text);
            } else if (commandType.equals("DELETE") && (!todoList.isEmpty() || intIndex >= 0 && intIndex < todoList.size())) {
                todoList.remove(intIndex);
            }
            }
        }

    }

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
