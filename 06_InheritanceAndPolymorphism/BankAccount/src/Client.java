public abstract class Client {

    protected double sumOfMoney;
    public abstract void createConditions();

    public Client(double sumOfMoney) {
        this.sumOfMoney = sumOfMoney;
    }

    public double getBalance() {
        return sumOfMoney;
    }
    public double putMoney(double amount) {
        return sumOfMoney += amount;
    }

    public double pullMoney(double amount) throws NegativeRemnantException {
        if (sumOfMoney < amount) throw new NegativeRemnantException(sumOfMoney, amount);
        sumOfMoney -= amount;
        System.out.println("Баланс карты: " + sumOfMoney);

        return sumOfMoney;
    }
}
