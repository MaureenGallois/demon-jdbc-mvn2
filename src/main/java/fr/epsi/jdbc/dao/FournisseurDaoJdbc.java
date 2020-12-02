package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements FournisseurDao {

    @Override
    public boolean delete(Fournisseur fournisseur) {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String login = bundle.getString("db.login");
        String pwd = bundle.getString("db.pwd");

        try (Connection connection = DriverManager.getConnection(url, login, pwd)) {
            String deleteQuery = "DELETE FROM FOURNISSEUR WHERE id=?";
            try (PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
                ps.setInt(1,fournisseur.getId());
                int rs=ps.executeUpdate();
                ps.close();
                connection.close();
                return true;

            } catch (SQLException e ) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String login = bundle.getString("db.login");
        String pwd = bundle.getString("db.pwd");
        int rs = 0;
        try (Connection connection = DriverManager.getConnection(url, login, pwd)) {
            String updateQuery = "UPDATE FOURNISSEUR SET NOM=? WHERE NOM=?";
            try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
                ps.setString(1, ancienNom);
                ps.setString(2,nouveauNom);
                rs=ps.executeUpdate();
                ps.close();
                connection.close();
                return rs;

            } catch (SQLException e ) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Fournisseur> extraire() {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String login = bundle.getString("db.login");
        String pwd = bundle.getString("db.pwd");

        try (Connection connection = DriverManager.getConnection(url, login, pwd)) {
            String selectQuery = "SELECT * FROM FOURNISSEUR";
            try (PreparedStatement ps = connection.prepareStatement(selectQuery)) {
                ResultSet rs = ps.executeQuery();
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
        return null;
    }

    @Override
    public void insert(Fournisseur fournisseur) {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String login = bundle.getString("db.login");
        String pwd = bundle.getString("db.pwd");

        try (Connection connection = DriverManager.getConnection(url, login, pwd)) {
            String insertQuery = "INSERT INTO FOURNISSEUR VALUES (?,?)";
            String selectQuery = "SELECT * FROM FOURNISSEUR";
            try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
                ps.setInt(1,fournisseur.getId());
                ps.setString(2,fournisseur.getNom());
                ps.executeUpdate();
                ps.close();
                connection.close();

            } catch (SQLException e ) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }
}
