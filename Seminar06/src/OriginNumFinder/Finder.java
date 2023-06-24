package OriginNumFinder;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Finder {
    public static int[] getRandomArray(int size, int maxValue) {
        int[] myArray = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            myArray[i] = rnd.nextInt(maxValue);
        }
        return myArray;
    }

    public static Set<Integer> arrayToSet(int[] array) {
        Set<Integer> uniques = new HashSet<>();
        for (Integer integer : array) {
            uniques.add(integer);
        }
        return uniques;
    }

    public static double percenter(int[] array, Set<Integer> uniques) {
        double percent = (double) uniques.size() * 100 / (double) array.length;
        return percent;
    }

}
