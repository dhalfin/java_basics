public class CardAccount extends BankAccount {

    public CardAccount(double surplus) {
        super(surplus);
    }

    public double withdraw(double amount) throws NegativeRemnantException {
        if(surplus < amount) throw new NegativeRemnantException(surplus, amount);
        surplus -= (amount + amount * 0.01);
        System.out.println("Баланс карты: " + surplus);
        return surplus;
    }
}
