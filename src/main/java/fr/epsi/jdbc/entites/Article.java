package fr.epsi.jdbc.entites;

public class Article {

    private int id;
    private String ref;
    private String designation;
    private float prix;
    private Fournisseur fournisseur;

    public Article(int id, String ref, String designation, float prix, Fournisseur fournisseur){
        this.id=id;
        this.ref=ref;
        this.designation=designation;
        this.fournisseur=fournisseur;
    }
}
