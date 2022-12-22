package org.mentorat.domain.shop;

public class NegativeSrtockException extends RuntimeException {

    public NegativeSrtockException(Article article) {
        super("Il n'y a pas assez %s".formatted(article.name()));
    }
}
