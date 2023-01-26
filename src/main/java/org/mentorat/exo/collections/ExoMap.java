package org.mentorat.exo.collections;

public class ExoMap {


    /*
    Exo craquage de coffre !

    Créer une première méthode qui :
    Générera un set de X mots de Y lettres
    À partir de ce set créer une map dont les clés seront la liste de mot et y mettre un entier aléatoire
    Faire la somme des valeurs au fur et à mesure que la map est initialisé

    ex :
    KEY | Value
    AA  |   5    : Somme == 5
    AH  |   10   : Somme == 10
    HY  |   6   : Somme == 16   etc...

    Créer une deuxième méthode qui prend en entrée un map => Map<String,Integer>
    Cette Map représente un coffre, la méthode ne connais pas les clés
    Pour cela elle doit attaquer la MAP en brute force, on va tout de meme l'aider en lui fournissant la taille de la clé

    Plusieurs méthodes sont possibles : tester toutes les possibilités sur toute l'entrée en partant de A...ZZZZ(..n) ou généré une clé de X lettre aléatoire et la testée sur chaque entrée

    Choisir la méthode voulue.
    Le plus important est que dès qu'une entrée de map est trouvée il faut conserver la valeur pour en faire la somme et finir par trouver la somme totale de la map

    il ne faudra pas resté des clés déjà faites

    Naturellement uen fois qu'une entrée de la Map est trouvée il ne faut pas retester pour gagner en efficacité
    (Faire une copie du restant de la map à tester)

    example (en supposant que je génère aléatoirement mes clés de tests):
    J'ai une map :

    PP  |    5
    AT  |   10
    YU  |   6
    T1
    je génère une clé de teste : ZE

      je la teste sur ma map

      Je ne trouve pas d'entrée je sauvegarde ZE comme étant déjà effectué

    T2
    je génère une clé non présente dans [ZE], ma nouvelle clé est PP

    je test sur map, et je trouve 5, j'ajoute 5 à la somme des valeurs trouvées
    je met PP dans ma liste des clés usées
    Je copie mon restant de map =>

    AT  |   10
    YU  |   6

    je recommance jusqu'à ne plus avoir d'entrée à trouver dans map et je retourne la somme trouvée

     */




}
