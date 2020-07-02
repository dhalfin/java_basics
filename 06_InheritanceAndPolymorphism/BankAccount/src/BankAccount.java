public class BankAccount {

    public double surplus;

    public BankAccount(double surplus) {
        this.surplus = surplus;
    }

    public double withdraw(double amount) throws NegativeRemnantException {
        if(surplus < amount) throw new NegativeRemnantException(surplus, amount);
        surplus -= amount;
        System.out.println("Баланс карты: " + surplus);
        return surplus;
    }

    public double deposit(double amount) {
        return surplus += amount;
    }

    public double getBalance() {
        return surplus;
    }

    boolean send(BankAccount receiver, double amount) {
        receiver.deposit(amount);
        return true;
    }


}
