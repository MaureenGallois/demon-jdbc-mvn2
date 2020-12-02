package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Article;


import java.util.List;

public interface ArticleDAO {
    List<Article> extraire();
    void insert(Article article);
    int update(float ancienPrix, float nouveauPrix);
    boolean delete(Article article);
}
