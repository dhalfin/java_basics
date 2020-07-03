import java.time.LocalDate;

public class DepositPaymentAccount extends BankAccount {
    private LocalDate dateDeposit = LocalDate.now();
    private LocalDate dateWithdraw = LocalDate.now();

    public DepositPaymentAccount(double surplus) {
        super(surplus);
    }

    @Override
    public double withdraw(double amount) throws NegativeRemnantException {
        if (surplus < amount) throw new NegativeRemnantException(surplus, amount);
        if (dateWithdraw.isAfter(dateDeposit.plusMonths(1))) {
            surplus = super.withdraw(amount);
            System.out.println("Баланс карты: " + surplus);
        } else {
            System.out.println("Нельзя снимать деньги в течение месяца после последнего внесения!");
        }
        return surplus;
    }

    public double deposit(double amount) {
        dateDeposit = LocalDate.now();
        return super.deposit(amount);
    }
}
