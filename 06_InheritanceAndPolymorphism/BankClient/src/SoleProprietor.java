import java.math.BigDecimal;

public class SoleProprietor extends Client {

    public SoleProprietor(BigDecimal sumOfMoney) {
        super(sumOfMoney);
    }

    public BigDecimal getBalance() {
        return sumOfMoney;
    }

    public BigDecimal pullMoney(BigDecimal amount) throws NegativeRemnantException {
        if (sumOfMoney.compareTo(amount) == -1) throw new NegativeRemnantException(sumOfMoney, amount);
        sumOfMoney = sumOfMoney.subtract(amount);
        System.out.println("Баланс карты: " + sumOfMoney);
        return super.pullMoney(amount);    }


    public BigDecimal putMoney(BigDecimal amount) {
        BigDecimal amountWithCommission = amount.add(getPutCommission(amount));
        this.sumOfMoney = sumOfMoney.add(amountWithCommission);
        return super.sumOfMoney;
    }

    @Override
    protected BigDecimal getPullCommission(BigDecimal amount) {
        return null;
    }

    @Override
    protected BigDecimal getPutCommission(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(1000)) == -1) {
            return amount.multiply(BigDecimal.valueOf(0.01));
        } else {
            return amount.multiply(BigDecimal.valueOf(0.005));
        }
    }

    @Override
    public void createConditions() {
        System.out.println("У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей." +
                " И с комиссией 0,5%, если сумма больше либо равна 1000 рублей." + "\n" +
                "Ваш баланс: " + getBalance());
    }
}
