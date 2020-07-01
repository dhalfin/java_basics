public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(50000);
        BankAccount otherAccount = new BankAccount(2300);
        account.send(otherAccount, 1000);

    }
}
