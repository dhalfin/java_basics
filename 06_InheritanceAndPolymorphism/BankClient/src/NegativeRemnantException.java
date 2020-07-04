import java.math.BigDecimal;

public class NegativeRemnantException extends Exception {

    public NegativeRemnantException(BigDecimal balance, BigDecimal sum) {
        super("Недостаточно средств на счёте! \n Баланс: " + balance + "\n Сумма: " + sum);
    }
}