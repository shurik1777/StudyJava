import CatLibrary.Cat;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] randomArray = OriginNumFinder.Finder.getRandomArray(300, 25);
        Set<Integer> randomSet = OriginNumFinder.Finder.arrayToSet(randomArray);
        System.out.println("Процент уникальности чисел: " + OriginNumFinder.Finder.percenter(randomArray, randomSet));

        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMMM d, yyyy", Locale.ENGLISH);
        Cat myCat = new Cat(2000, "Барсик", 245, formatter.parse("Sat, April 4, 2019"), true, 1);
        Cat motherCat = new Cat(3000, "Кеша", 245, formatter.parse("Sat, April 4, 2010"), false, 2);
        HashSet<Cat> catSet = new HashSet<Cat>();
        catSet.add(myCat);
        catSet.add(motherCat);

        System.out.println(myCat);
        System.out.println(motherCat);

        System.out.println(myCat.equals(motherCat));
        System.out.println(catSet.contains(motherCat));
    }

    public static void setTest() {
        HashSet<Integer> numSet = new HashSet<Integer>();
        // {1, 2, 3, 2, 4, 5, 6, 3}
        numSet.add(1);
        numSet.add(6);
        numSet.add(4);
        numSet.add(3);
        numSet.add(5);
        numSet.add(2);
        numSet.add(3);
        numSet.add(6);
        System.out.println(numSet);

        LinkedHashSet<Integer> numsSet1 = new LinkedHashSet<Integer>();
        // {1, 2, 3, 2, 4, 5, 6, 3}
        numsSet1.add(1);
        numsSet1.add(6);
        numsSet1.add(4);
        numsSet1.add(3);
        numsSet1.add(5);
        numsSet1.add(2);
        numsSet1.add(3);
        numsSet1.add(6);
        System.out.println(numsSet1);

        TreeSet<Integer> numsSet2 = new TreeSet<Integer>();
        // {1, 2, 3, 2, 4, 5, 6, 3}
        numsSet2.add(1);
        numsSet2.add(6);
        numsSet2.add(4);
        numsSet2.add(3);
        numsSet2.add(5);
        numsSet2.add(2);
        numsSet2.add(3);
        numsSet2.add(6);
        System.out.println(numsSet2);
    }
}