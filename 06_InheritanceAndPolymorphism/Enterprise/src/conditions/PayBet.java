package conditions;

public enum PayBet {

    OPERATOR(900.00),
    MANAGER(1100.00),
    TOP_MANAGER(2200.00);

    private double bet;

    PayBet(double bet) {
        this.bet = bet;
    }

    public double getBet() {
        return bet;
    }
}
