import java.math.BigDecimal;
import java.util.function.BiFunction;

public class LegalEntity extends Client {

    public LegalEntity(BigDecimal sumOfMoney) {
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
        BigDecimal amountWithCommission = amount.add(getPullCommission(amount));
        this.sumOfMoney = sumOfMoney.subtract(amountWithCommission);
        return super.sumOfMoney;
    }

    @Override
    protected BigDecimal getPullCommission(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.01));
    }

    @Override
    protected BigDecimal getPutCommission(BigDecimal amount) {
        return null;
    }

    @Override
    public void createConditions() {
        System.out.println("У юридических лиц снятие с комиссией 1%." + "\n" +
                "Ваш баланс: " + getBalance());
    }
}


