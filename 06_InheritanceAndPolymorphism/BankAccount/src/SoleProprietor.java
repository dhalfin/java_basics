public class SoleProprietor extends Client {

    public SoleProprietor(double sumOfMoney) {
        super(sumOfMoney);
    }

    public double getBalance() {
        return sumOfMoney;
    }

    public double pullMoney(double amount) throws NegativeRemnantException {
        if (sumOfMoney < amount) throw new NegativeRemnantException(sumOfMoney, amount);
        sumOfMoney -= amount;
        System.out.println("Баланс карты: " + sumOfMoney);
        return super.pullMoney(amount);
    }

    @Override
    public double putMoney(double amount) {
        if (amount < 1000) {
            return super.putMoney(amount - amount * 0.01);
        } else {
            return super.putMoney(amount - amount * 0.005);
        }
    }

    @Override
    public void createConditions() {
        System.out.println("У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей." +
                " И с комиссией 0,5%, если сумма больше либо равна 1000 рублей." + "\n" +
                "Ваш баланс: " + getBalance());
    }
}
