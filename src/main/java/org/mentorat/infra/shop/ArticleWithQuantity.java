package org.mentorat.infra.shop;

import org.mentorat.domain.shop.Article;

public class ArticleWithQuantity {
    private Article article;
    private int quantity;


    public Article getArticle() {
        return article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
