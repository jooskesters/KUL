package Utility;

import Entity.Person;

public class PersonUtil {

    public static int iterativeSiblingCount(Person p){
        int amountOfSiblings = 0;
        while (p.getNextOldestSibling() != null){
            p = p.getNextOldestSibling();
            amountOfSiblings ++;
        }
        return amountOfSiblings;
    }

}
