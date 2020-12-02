package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Fournisseur;

public class TextDAO {
    public static void main(String[] args) {
        FournisseurDaoJdbc fournisseurDAO = new FournisseurDaoJdbc();
        Fournisseur fournisseur = new Fournisseur('4', "L’Espace Création");


        fournisseurDAO.insert(fournisseur);
        fournisseurDAO.extraire();
        fournisseurDAO.delete(fournisseur);
        fournisseurDAO.extraire();
    }
}
