package org.mentorat.service.shop;

import org.mentorat.domain.shop.Article;
import org.mentorat.domain.shop.Stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StockDataPort {

    Map<Article,Integer> currentStock();

    void addArticles(List<Article> article);

    void removeArticles(HashMap<Article,Integer> articlesAndQuantity);

}
