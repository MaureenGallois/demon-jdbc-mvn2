package fr.epsi.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class TestInsertion {

    public static void main(String[] args) {


        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String login = bundle.getString("db.login");
        String pwd = bundle.getString("db.pwd");

        try (Connection connection = DriverManager.getConnection(url, login, pwd)) {
            String insertQuery = "INSERT INTO FOURNISSEUR VALUES ('4','La Maison de la Peinture')";
            String selectQuery = "SELECT * FROM FOURNISSEUR";
             try (Statement st = connection.createStatement()) {
                int rs= st.executeUpdate(insertQuery);
                 ResultSet select = st.executeQuery(selectQuery);
                 while (select.next()) {
                     System.out.println(select.getString("NOM"));
                 }
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
