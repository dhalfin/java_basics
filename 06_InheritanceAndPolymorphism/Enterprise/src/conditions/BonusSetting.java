package conditions;

public enum BonusSetting {

    OPERATOR(0),
    MANAGER(0.5),
    TOP_MANAGER(1.5);

    private double bonusAmount;

    BonusSetting(double amount) {
        this.bonusAmount = amount;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }
}
