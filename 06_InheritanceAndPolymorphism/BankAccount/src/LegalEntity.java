public class LegalEntity extends Client {

    public LegalEntity(double sumOfMoney) {
        super(sumOfMoney);
    }

    public double getBalance() {
        return sumOfMoney;
    }

    public double putMoney(double amount) {
        return super.putMoney(amount);
    }

    @Override
    public double pullMoney(double amount) throws NegativeRemnantException {
        return super.pullMoney(amount + amount * 0.01);
    }

    @Override
    public void createConditions() {
        System.out.println("У юридических лиц снятие с комиссией 1%." + "\n" +
                "Ваш баланс: " + getBalance());
    }
}


