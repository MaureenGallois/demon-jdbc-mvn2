package fr.epsi.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class TestUpdate {

    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String login = bundle.getString("db.login");
        String pwd = bundle.getString("db.pwd");

        try (Connection connection = DriverManager.getConnection(url, login, pwd)) {
            String updateQuery = "UPDATE FOURNISSEUR SET nom = REPLACE(nom, 'La Maison de la Peinture', 'La Maison des Peintures') WHERE id=4";
            try (Statement st = connection.createStatement()) {
                int rs=st.executeUpdate(updateQuery);
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
