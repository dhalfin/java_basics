import java.math.BigDecimal;

public class PhysicalEntity extends Client {

    public PhysicalEntity(BigDecimal sumOfMoney) {
        super(sumOfMoney);
    }

    public BigDecimal getBalance() {
        return sumOfMoney;
    }

    public BigDecimal putMoney(BigDecimal amount) {
        return super.putMoney(amount);
    }

    public BigDecimal pullMoney(BigDecimal amount) throws NegativeRemnantException {
        if (sumOfMoney.compareTo(amount) == -1) throw new NegativeRemnantException(sumOfMoney, amount);
        sumOfMoney = sumOfMoney.subtract(amount);
        System.out.println("Баланс карты: " + sumOfMoney);
        return super.pullMoney(amount);
    }

    @Override
    protected BigDecimal getPullCommission(BigDecimal amount) {
        return null;
    }

    @Override
    protected BigDecimal getPutCommission(BigDecimal amount) {
        return null;
    }

    @Override
    public void createConditions() {
        System.out.println("У физических лиц пополнение и снятие происходит без комиссии." + "\n" +
                "Ваш баланс: " + getBalance());
    }
}
