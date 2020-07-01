import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DepositPaymentAccount extends BankAccount {
    LocalDate dateDeposit = LocalDate.now();
    LocalDate dateWithdraw = LocalDate.now();

    public DepositPaymentAccount(double surplus) {
        super(surplus);
    }

    public double withdraw(double amount) throws NegativeRemnantException {
        if (surplus < amount) throw new NegativeRemnantException(surplus, amount);
        //LocalDate dateWithdraw = LocalDate.now();
        if (DAYS.between(dateDeposit, dateWithdraw) > 30) {
            surplus -= amount;
            System.out.println("Баланс карты: " + surplus);
        } else {
            System.out.println("Нельзя снимать деньги в течение месяца после последнего внесения!");
        }
        return surplus;
    }

    public double deposit(double amount) {
        surplus += amount;
        return Double.parseDouble(dateDeposit + "\n" + surplus);
    }
}
