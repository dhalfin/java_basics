import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Loader {

    public static List<Client> contractors;
    private static int PRINT_WIDTH = 107;

    public static void main(String[] args) throws IOException {
        String CSV_FILE = "src/main/resources/movementList.csv";

        try (FileReader fileReader = new FileReader(CSV_FILE)) {
            contractors = new CsvToBeanBuilder<Client>(fileReader)
                    .withType(Client.class)
                    .build()
                    .parse();
        }

        contractors.stream().collect(Collectors.groupingBy(Client::getNameCompany,
                Collectors.mapping(Report::fromTransaction,
                        Collectors.reducing(new Report(), Report::merge)
                )))
                .forEach(Report::printRow);
        printTotal(contractors.stream()
                .map(Report::fromTransaction)
                .reduce(new Report(), Report::merge));
    }

    private static void printTotal(Report report) {
        System.out.println("-".repeat(PRINT_WIDTH));
        Report.printRow("ИТОГО СУММА", report);
    }
}
