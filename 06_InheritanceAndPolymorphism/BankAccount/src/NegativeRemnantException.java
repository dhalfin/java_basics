public class NegativeRemnantException extends Exception {

    public NegativeRemnantException(double balance, double sum) {
        super("Недостаточно средств на счёте! \n Баланс: " + balance + "\n Сумма: " + sum);
    }
}