package org.mentorat.service.calculator;

import org.mentorat.service.UserAdapter;

public class Calculator {

    /*
    Premier exo : Réaliser une calculatrice
    Dans un premier temps essaye de coder le corps des méthodes sans les modifier et valide les tests
    Ensuite si tu veux optimiser tes méthodes créer une copie de cette classe (ca evitera de casser les tests)

    NOTE importante :
    - Ne jamais faire confiance à l'utilisateur
    - Ne pas utliser autre chose que le UserAdapter
    - L'application ne doit pas lmever d'exceptions

    WARNING :
    Les signatures n'ont pas d'encapsulation (package proctected) c'est volontaire pour faciliter les tests

    Help :
    N'hésite pas à regarder dans la classe MenuService tu y trouvera de quoi faire ce qui faut pour manipuler la console

    Tu auras surement besoin des api java.lang.Integer et java.lang.String pour t'aider à faire des convertions


    !! DISCLAIMER !!
    La plupart des résultats sont dans les tests, essaye de ne pas les regarder avant d'avoir finit l'exo

    Si tu veux eviter qu'intelliJ t'ouvres le fichier à chaque test tu peux lancer les tests toi même via un terminal à la racine du projet
    commande :  mvn test

     */

    private final UserAdapter adapter;

    public Calculator(UserAdapter adapter) {
        this.adapter = adapter;
    }

    public void start() {
        //Afficher le menu pour aider l'utilisateur
        displayHelp();
        //Demander à l'utilisateur de saisir le premier nombre
        askANumber();
        //Demander l'opérande
        askOperand();
        //Demander à l'utilisateur de saisir le deuxième nombre opération
        askANumber();
        //Faire le calcul
        calc(0, 0, null);
        //Afficher le résultat
        displayOperation(0,0,null);
    }


    // Cette méthode doit afficher dans la console un petit menu d'aide à l'utilisateur comme pour le menu principal
    void displayHelp() {
    }

    // Cette méthode doit retourner une saisie utilisateur (voir exemple du menu)
    // A chaque fois que cette ùéthode est appelé je doit aider l'utilisateur (affichage)
    int askANumber() {
        return 0;
    }

    //Idem que pour le nombre ici on ne doit pouvoir saisir que des opérateurs connu
    // opérateur attendus : + - * / % à minima
    Operand askOperand() {
        return null;
    }

    //Cette méthode doit effectué le calcul final
    double calc(int firstNumber, int secondNumber, Operand operation) {
        return 0.0;
    }

    //Cette méthode affiche le résultat final avec le detail de l'opération
    void displayOperation(int firstNumber, int secondNumber, Operand operation) {
    }


    enum Operand {
        ADDITION,
        SUBSTRACTION,
        MULTIPLICATION,
        DIVISION,
        MODULO;

    }
}
