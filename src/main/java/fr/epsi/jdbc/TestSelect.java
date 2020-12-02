package fr.epsi.jdbc;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelect {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String login = bundle.getString("db.login");
        String pwd = bundle.getString("db.pwd");

        try (Connection connection = DriverManager.getConnection(url, login, pwd)) {
            List<Fournisseur> fournisseur = new ArrayList<>();
            String selectQuery = "SELECT * FROM FOURNISSEUR";
            try (Statement st = connection.createStatement()) {
                ResultSet rs = st.executeQuery(selectQuery);
                while (rs.next()) {
                    fournisseur.add(new Fournisseur(rs.getInt("ID"),rs.getString("NOM")));
                }
                System.out.println(fournisseur);
                connection.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
