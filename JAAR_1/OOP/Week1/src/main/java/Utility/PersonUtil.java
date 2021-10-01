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

    public static int iterativeAdultSiblingCount(Person p){
        int amountOfSiblings = 0;
        while (p.getNextOldestSibling() != null){
            p = p.getNextOldestSibling();
            if (p.getAge() >= 18){
                amountOfSiblings ++;
            }

        }
        return amountOfSiblings;
    }

    public static int recursiveSiblingCount(Person p){
        int siblingCount = 0;
        if (p.getNextOldestSibling() != null){
            siblingCount++;
            siblingCount += recursiveSiblingCount(p.getNextOldestSibling());
        }
        return siblingCount;
    }

    public static int recursiveAdultSiblingCount(Person p){
        int siblingCount = 0;
        if (p.getNextOldestSibling() == null) {
            return 1;
        }
        if (p.getAge() >= 18){
            siblingCount++;
        }
        siblingCount += recursiveAdultSiblingCount(p.getNextOldestSibling());
        return siblingCount;

    }
}
