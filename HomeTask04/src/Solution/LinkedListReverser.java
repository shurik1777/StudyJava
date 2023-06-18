package Solution;

import java.util.LinkedList;

public class LinkedListReverser {
    /*
    Задание
1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
     */
    public static LinkedList reverseLinkedList(LinkedList list) {
        // Создаем новый пустой связный список
        LinkedList reversedList = new LinkedList();
        // Проходим по элементам исходного списка с конца к началу
        for (int i = list.size() - 1; i >= 0; i--) {
            // Добавляем каждый элемент в новый список
            reversedList.add(list.get(i));
        }
        // Возвращаем перевернутый список
        return reversedList;
    }

}
