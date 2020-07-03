public class CardAccount extends BankAccount {

    public CardAccount(double surplus) {
        super(surplus);
    }

    @Override
    public double withdraw(double amount) throws NegativeRemnantException {
        return super.withdraw(amount + amount * 0.01);
    }
}
