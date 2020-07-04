import java.math.BigDecimal;

public abstract class Client {

    protected BigDecimal sumOfMoney;
    public abstract void createConditions();

    public Client(BigDecimal sumOfMoney) {
        this.sumOfMoney = sumOfMoney;
    }

    public BigDecimal getBalance() {
        return sumOfMoney;
    }
    public BigDecimal putMoney(BigDecimal amount) {

        return sumOfMoney = sumOfMoney.add(amount);
    }

    protected abstract BigDecimal getPullCommission(BigDecimal amount);

    protected abstract BigDecimal getPutCommission(BigDecimal amount);

    public BigDecimal pullMoney(BigDecimal amount) throws NegativeRemnantException {
        if (sumOfMoney.compareTo(amount) == -1) throw new NegativeRemnantException(sumOfMoney, amount);
        sumOfMoney = sumOfMoney.subtract(amount);
        System.out.println("Баланс карты: " + sumOfMoney);

        return sumOfMoney;
    }
}
