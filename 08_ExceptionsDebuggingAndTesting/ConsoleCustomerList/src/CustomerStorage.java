import java.util.HashMap;
import java.util.regex.Pattern;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws EmailNotValidException, NumberNotValidException {
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
        if (components.length != 4) {
            throw new IllegalArgumentException("Неверный формат ввода.\nBeрный формат: add Василий Петров vasiliy.petrov@gmail.com +79261234567");
        }
        if (!Pattern.compile(".+@.+\\..+").matcher(components[2]).matches()) {
            throw new EmailNotValidException("Электронная почта некорректного вида, введите почту правильно aaaa@aaa.aa");
        }
        if (!Pattern.compile("\\+7\\d{10}").matcher(components[3]).matches()) {
            throw new NumberNotValidException("Номер телефона не соответсвует формату, введите телефон правильно +71111111111 ");
        }
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}