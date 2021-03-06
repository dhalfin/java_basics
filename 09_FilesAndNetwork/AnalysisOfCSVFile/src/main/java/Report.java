import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Report {
    private double income;
    private double withdraw;

    public Report(double income, double withdraw) {
        this.income = income;
        this.withdraw = withdraw;
    }

    public Report() {
    }

    public static Report merge(Report r1, Report r2) {
        return new Report(r1.income + r2.income, r1.withdraw + r2.withdraw);
    }

    public static Report fromTransaction(Transaction c) {
        return new Report(transform(c.getComing()), transform(c.getConsumption()));
    }

    public static double transform(String number) {
        Double transformed = Double.parseDouble(number.replace(',', '.').trim());
        return transformed;
    }

    public static void printRow(String name, Report report) {
        System.out.printf("%-55s Приход %,15.2f; \t Расход %,15.2f%n",
                name, report.income, report.withdraw);
    }


}