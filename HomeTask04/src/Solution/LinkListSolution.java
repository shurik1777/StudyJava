package Solution;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
Задание1.
Пусть дан LinkedList с несколькими элементами.
Реализуйте метод, который вернет “перевернутый” список. Case REVERS и REVERS2 - сделано.
*/
public class LinkListSolution {

    private static LinkedList<String> list = new LinkedList<>();


    public static void run() {
        boolean getiteration = true;
        while (getiteration) {
            String cmd = InputUser("Введите команду");
            String[] cLine = cmd.toUpperCase().split("~");
            // 11111~5
            switch (cLine[0]) {
                case "EXIT":
                    getiteration = false;
                    break;
                case "PRINT":
                    System.out.println(list.get(Integer.parseInt(cLine[1])));
                    break;
                case "LIST":
                    while (list.size() > 0) {
                        System.out.println(list.pop());
                    }
                case "REVERS":
                    // Через итератор
                    if (list.size() > 0) {
                        Iterator<String> iterator = list.descendingIterator();
                        while (iterator.hasNext()) {
                            System.out.println(iterator.next());
                        }
                        list.removeLast();
                    } else {
                        System.out.println("Список пуст");
                    }
                    break;
                case "REVERS2":
                    // Через перебор и добавление .add
                    LinkedList<Integer> reversedList = reverseLinkedList(list);
                    System.out.println("Перевернутый список: " + reversedList);

                default:
                    if (cLine.length > 1) {
                        if (isInt(cLine[1])) {
                            adder(cLine, list);
                        }
                    } else {
                        list.addFirst(cLine[0]);
                    }

                    break;

            }
        }

    }

    private static LinkedList reverseLinkedList(LinkedList list) {
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


    private static String InputUser(String message) {
        System.out.print(message + " -> ");
        Scanner scannerNumber = new Scanner(System.in);
        return scannerNumber.nextLine();
    }

    private static boolean isInt(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static List<String> adder(String[] splitted, List<String> list) {
        if (isInt(splitted[1])) {
            int num = Integer.parseInt(splitted[1]);
            if (num > list.size()) {
                for (int i = list.size() - num; i < num + 1; ++i) {
                    list.add(" ");

                }
            }
            list.add(num, splitted[0]);
        }
        return list;
    }
}
