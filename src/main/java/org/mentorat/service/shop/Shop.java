package org.mentorat.service.shop;

public class Shop {
    /*
        Exo 2 : Le Magasin

        L'objectif ici est de pouvoir proper un sous menu via la console où tu peux afficher le stock.

        L'utilisateur peut ajouter des articles (uniquement ceux présente dans le stock) dans son panier

        Si il y a des articles dans son panier un prompt lui sera proposer avant de quitter pour abandoner ou non ses achats

        A tout moment l'utilisateur peux demander à payer ses articles, dans ce cas il faudra faire la somme total
        des articles demandés, l'afficher et pour le calcul il faudra utiliser ta calculette(Calculator).

        Une fois le montant calculé il faut l'afficher à l'utilisateur qui peut revenir en arrière et continuer ses achat,
         abandonner ou payer (valider, on gère pas les paiements ici :D)

        Une fois valider il faut mettre à jour le stock.

        Bonus :
        Dans le cadre de l'exercice on doit également pouvoir effectué une "livraison" donc ajouter des articles au stock.
        A toi de voir si tu veux le faire depuis cette classe Shop ou une autre mais le stock doit etre commun
        Par contre ca sera un menu différent dans le menu principal. Il est pas impossible qu'il y est un piège dans ce Bonus (uniquement)

        N'hésite pas a reutiliser ce que tu as fais jusqu'ici.

        Tu es libre de créer tes méthodes, classes ou packages sous certaines conditions :

        Les classes dans le package domain ne doivent jamais avoir d'import depuis un package service ou infra
        Les classes dans le package service ne doivent jamais avoir d'import depuis le package d'infra

        Les classes du package domain et service ne doivent avoir aucune notion d'infrastructure comme la console (System.in/out)
        ou de fichier (JSON), depuis ces packages je ne dois jamais savoir quel élément je manipule (fichier, base de données, web etc..)
        (C'est un principe de la clean architecture, on le reverra en detail plus tard)

        NOTE :
         - Tu peux utiliser l'objet stockDataPort pour lister les articles, en ajouter ou en retirer du stock
         - J'ai volontairement mis une List dans un cas et une Map dans l'autre pour te faire manipuler les deux.

        AUTRES :
        - Ne pas modifier ou utiliser directement  les classes ArticleWithQuantity/JsonStockDataAdapter pour le moment, en cas de bug n'hésite
        pas à me demander car pour le moment c'est pas l'objet de l'exercice d'impacter ces classes, on les regardera
        ensemble pour t'expliquer ce que ca fait ce que j'ai utiliser etc.

     */
    private final StockDataPort stockDataPort;

    public Shop(StockDataPort stockDataPort) {
        this.stockDataPort = stockDataPort;
    }
}
