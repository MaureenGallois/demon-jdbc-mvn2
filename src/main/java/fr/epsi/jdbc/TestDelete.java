package fr.epsi.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class TestDelete {

    public static void main(String[] args) {


        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String login = bundle.getString("db.login");
        String pwd = bundle.getString("db.pwd");

        try (Connection connection = DriverManager.getConnection(url, login, pwd)) {
            String deleteQuery = "DELETE FROM FOURNISSEUR WHERE id=4";
            try (Statement st = connection.createStatement()) {
                int rs=st.executeUpdate(deleteQuery);
                st.close();
                connection.close();

            } catch (SQLException e ) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }
}
