import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLJunction {

    private final String url;
    private final String user;
    private final String pass;

    public SQLJunction() {
        url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
        user = "root";
        pass = "test";
    }

    public Statement getJunction() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, pass);
        return connection.createStatement();
    }
}


