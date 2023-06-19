package Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListTest {
    public static void TimeTest(int size) {
        Random rnd = new Random();
        //  Создание простого листа:
        //  (можно оба этих листа объявить через List<Integer>)
        List<Integer> simpleList = new ArrayList<>();
        List<Integer> linkList = new LinkedList<>();

        // При создании листов с явным указанием можно добавить доп. функционал
        // ArrayList<Integer> simpleList = new ArrayList<>();
        // LinkedList<Integer> linkList = new LinkedList<>();

        // компьютер выделяет 4 байта на время 256 * 256 * 256 * 256
        // было принято взять тчк отсчета за 1970й год Unix(формат отсчета long), а в Excel за 1900

        long cutTime = System.currentTimeMillis();
        System.out.println(cutTime);

        for (int i = 0; i < size; i++) {
            simpleList.add(1);
        }
        System.out.println("Простой список конец: " + (System.currentTimeMillis() - cutTime));
        for (int i = 0; i < size; i++) {
            linkList.add(1);
        }
        System.out.println("Связный список конец: " + (System.currentTimeMillis() - cutTime));
        simpleList.clear();
        linkList.clear();
        for (int i = 0; i < size/10; i++) {
            simpleList.add(0, 1);
        }
        System.out.println("Простой список начало: " + (System.currentTimeMillis() - cutTime));
        for (int i = 0; i < size/10; i++) {
            linkList.add(0, 1);
        }
        System.out.println("Связный список начало: " + (System.currentTimeMillis() - cutTime));

        for (int i = 0; i < size/10; i++) {
            simpleList.add(rnd.nextInt(10_000), 1);
        }
        System.out.println("Простой список середина: " + (System.currentTimeMillis() - cutTime));
        for (int i = 0; i < size/10; i++) {
            linkList.add(rnd.nextInt(10_000), 1);
        }
        System.out.println("Связный список середина: " + (System.currentTimeMillis() - cutTime));

    }
}
