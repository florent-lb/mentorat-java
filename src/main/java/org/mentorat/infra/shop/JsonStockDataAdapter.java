package org.mentorat.infra.shop;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.mentorat.domain.shop.Article;
import org.mentorat.domain.shop.NegativeSrtockException;
import org.mentorat.domain.shop.Stock;
import org.mentorat.service.shop.StockDataPort;

import java.util.*;
import java.util.stream.Collectors;

public class JsonStockDataAdapter implements StockDataPort {

    private final Stock stock;

    public JsonStockDataAdapter() {
        this.stock = initialiseStock();
    }

    private Stock initialiseStock() {
        try (Jsonb jsonb = JsonbBuilder.create()) {
            ArticleWithQuantity[] articleWithQuantities = jsonb.fromJson(this.getClass().getClassLoader().getResourceAsStream("initialStock.json"),
                    ArticleWithQuantity[].class
            );
            return Arrays.stream(articleWithQuantities)
                    .collect(Collectors.toMap(
                            ArticleWithQuantity::getArticle,
                            ArticleWithQuantity::getQuantity,
                            Integer::sum,
                            Stock::new
                    ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<Article, Integer> currentStock() {
        return
                Collections.unmodifiableMap(stock);
    }

    @Override
    public void addArticles(List<Article> articles) {

        Map<Article, Long> collect = articles.stream().collect(Collectors.groupingBy(article -> article, Collectors.counting()));
        collect
                .entrySet()
                .forEach(entry -> stock.merge(
                        entry.getKey(),
                        entry.getValue().intValue(),
                        Integer::sum
                ));

    }

    @Override
    public void removeArticles(HashMap<Article, Integer> articlesAndQuantity) {
        articlesAndQuantity
                .entrySet()
                .forEach(entry -> stock.merge(
                        entry.getKey(),
                        entry.getValue().intValue(),
                        (currentStock, itemToRemove) -> {

                            if (currentStock - itemToRemove < 0) {
                                throw new NegativeSrtockException(entry.getKey());
                            }
                            return currentStock - itemToRemove;
                        }
                ));
    }

}
