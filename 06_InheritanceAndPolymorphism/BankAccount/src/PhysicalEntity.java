public class PhysicalEntity extends Client {

    public PhysicalEntity(double sumOfMoney) {
        super(sumOfMoney);
    }

    public double getBalance() {
        return sumOfMoney;
    }

    public double putMoney(double amount) {
        return super.putMoney(amount);
    }

    public double pullMoney(double amount) throws NegativeRemnantException {
        if (sumOfMoney < amount) throw new NegativeRemnantException(sumOfMoney, amount);
        sumOfMoney -= amount;
        System.out.println("Баланс карты: " + sumOfMoney);
        return super.pullMoney(amount);
    }

    @Override
    public void createConditions() {
        System.out.println("У физических лиц пополнение и снятие происходит без комиссии." + "\n" +
                "Ваш баланс: " + getBalance());
    }
}
