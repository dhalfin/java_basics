import java.util.ArrayList;
import java.util.List;
import java.util.logging.LoggingPermission;

public class Loader {



    public static void main(String[] args) {
        List<Operator> operators = new ArrayList<Operator>();
        Company company = new Company();
        company.hireAll();
    }
}
