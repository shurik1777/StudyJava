package Solution;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void filler() {
        ArrayList<Integer> array = new ArrayList<>();
        Random rnd = new Random();
//        List<Integer> numL = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            array.add(rnd.nextInt(100));
        }
        System.out.println(array);
//        array.sort(Integer::compareTo);
//        System.out.println(numL);
        Collections.sort(array);
        System.out.println(array);
    }

    public static List<Integer> generateRandomInt(int count) {
        Random rnd = new Random();
        return Stream.generate(rnd::nextInt).limit(count).collect(Collectors.toList());
    }

    public static void execute() {
        List<Integer> integers = generateRandomInt(10);
        System.out.println(integers);
        integers.sort(Integer::compareTo);
        System.out.println(integers);

    }
}
