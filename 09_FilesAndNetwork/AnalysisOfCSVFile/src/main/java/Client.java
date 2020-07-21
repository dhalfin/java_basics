import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Client {

    @CsvBindByName(column = "Тип счёта", required = true)
    private String type;

    @CsvBindByName(column = "Номер счета", required = true)
    private String number;

    @CsvBindByName(column = "Валюта", required = true)
    private String currency;

    @CsvBindByName(column = "Дата операции", required = true)
    private String transactionDate;

    @CsvBindByName(column = "Референс проводки", required = true)
    private String transactionReference;

    @CsvBindByName(column = "Описание операции", required = true)
    private String describing;

    @CsvBindByName(column = "Приход", required = true)
    private String coming;

    @CsvBindByName(column = "Расход", required = true)
    private String expenditure;

    public static String getNameCompany(Client client) {
        String[] transaction = client.describing.trim().split(" {3,}");
        String[] temp = transaction[1].split("/");
        String[] inputsTemp = temp[temp.length - 1].split("\\\\");
        String inputs = inputsTemp[inputsTemp.length - 1];
        return inputs;
    }

    public String getComing() {
        return coming;
    }

    public String getConsumption() {
        return expenditure;
    }
}
