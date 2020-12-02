package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Article;

import java.util.List;

public class ArticleDaoJdbc implements ArticleDAO{
    @Override
    public List<Article> extraire() {
        return null;
    }

    @Override
    public boolean delete(Article article) {
        return false;
    }

    @Override
    public int update(float ancienPrix, float nouveauPrix) {
        return 0;
    }

    @Override
    public void insert(Article article) {

    }
}
