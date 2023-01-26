package org.mentorat.exo.collections;

import java.util.List;
import java.util.Set;

public class ExoSet {
    // Les lettres X et Y peuvent être renommées

   // 1. initialiser un Set avec 10 mots de X lettres aléatoires
    /* où X est le nombre de lettres par mot
    // Tips : généré un nombre aléatoire avec la classe RandomGenerator, declaration possible :
    // RandomGenerator rand = new SecureRandom();
    // Tips2 : un char est un entier dans la table ASCII
    ex : char myLetter = 65  ==> 'A'
    // https://www.javatpoint.com/java-ascii-table
     */

    public Set<String> initializeSet(int X)
    {
        return Set.of();
    }


    //2. Créer une méthode qui retourne un SET uniquement si au moins X mots de Y lettres commencent par la lettre demandée en paramètre
    /*
    Exemple :

    Si je demande 5 mots commençant par G
    GAERT
    GHAYE
    GCKNV
    GDERT
    AYUFT
    GHDYT

    c'est valide

    GAERT
    GHAYE
    HCKNV
    JDERT
    AYUFT
    GHDYT

    ce n'est pas valide
     */
    private Set<String> getSecureSet(int X,int Y, char letterAsked){
        return Set.of();
    }

}
