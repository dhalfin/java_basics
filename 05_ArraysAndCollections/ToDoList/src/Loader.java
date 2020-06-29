import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    private final static Pattern COMMAND_PATTERN = Pattern.compile("(?<commandType>ADD|LIST|EDIT|DELETE)\\s*(?<dealNo>-?\\d*)\\s*(?<text>.*)");
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
                if (index.equals("")) {
                    index = String.valueOf(todoList.size());
                }
                int intIndex = Integer.parseInt(index);
                String text = matcher.group("text");

                if (commandType.equals("LIST")) {
                   list();
                } else if (commandType.equals("ADD")) {
                   add(intIndex, text);
                } else if (commandType.equals("EDIT")) {
                    edit(intIndex, text);
                } else if (commandType.equals("DELETE")) {
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

    private static void add(int intIndex, String text) {
        if (intIndex < 0 || intIndex > todoList.size()) {
            System.out.println("Введите положительный номер задачи от 0 и до " + todoList.size() + ", включая " + todoList.size());
          } else {
            todoList.add(intIndex, text);
        }
    }

    private static void edit(int intIndex, String text) {
       try {
           if (intIndex < 0 || intIndex > todoList.size()) {
               System.out.println("Введите положительный номер задачи от 0 и до " + todoList.size() + ", не включая " + todoList.size());
           } else {
                todoList.set(intIndex, text);
           }
       }
       catch (IndexOutOfBoundsException e){
           System.out.println("Нужно ввести номер дела менее " + todoList.size());
       }
    }

    private static void deleteDealNo(int intIndex) {
        if (intIndex >= 0 && intIndex < todoList.size()) {
            todoList.remove(intIndex);
        } else {
            System.out.println("Невозможно удалить из несуществующего списка или неправильно введен номер дела!");
        }
    }
}

//!todoList.isEmpty() ||

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

