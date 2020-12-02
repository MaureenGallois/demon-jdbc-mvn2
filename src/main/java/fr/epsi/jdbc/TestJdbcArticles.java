package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Fournisseur;

public class TestJdbcArticles {
    public static void main(String[] args) {

        FournisseurDaoJdbc fournisseurDAO = new FournisseurDaoJdbc();
        Fournisseur fournisseur = new Fournisseur('4', "La Maison de la Peinture");

        fournisseurDAO.insert(fournisseur);
        fournisseurDAO.extraire();
    }
}
