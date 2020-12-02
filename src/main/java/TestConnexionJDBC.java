import java.sql.*;
import java.util.ResourceBundle;

public class TestConnexionJDBC {

    public static void main(String[] args) {


        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String login = bundle.getString("db.login");
        String pwd = bundle.getString("db.pwd");

        try (Connection connection = DriverManager.getConnection(url, login, pwd)) {
            String selectQuery = "SELECT * FROM FOURNISSEUR";
            try (Statement st = connection.createStatement()) {
                ResultSet rs = st.executeQuery(selectQuery);
                while (rs.next()) {
                    System.out.println(rs.getString("NOM"));
                }
                connection.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
