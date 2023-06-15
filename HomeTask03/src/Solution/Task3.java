package Solution;
/* Задание

Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

*/

import java.util.ArrayList;
import java.util.Collections;

public class Task3 {


    public static void CollectionsSort() {

        // Создадим список целых чисел
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Найдем минимальное значение в списке
        int minNumber = Collections.min(list);
        System.out.println("Минимальное значение: " + minNumber);

        // Найдем максимальное значение в списке
        int maxNumber = Collections.max(list);
        System.out.println("Максимальное значение: " + maxNumber);

        // Найдем среднее значение в списке
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        double averageNumber = (double) sum / list.size();
        System.out.println("Среднее значение: " + averageNumber);
    }

    public static void Sort() {
        ArrayList<Integer> nums = new ArrayList<Integer>(); // создаем список целых чисел

        // добавляем числа в список
        nums.add(5);
        nums.add(7);
        nums.add(3);
        nums.add(12);
        nums.add(8);

        int sum = 0;
        int min = nums.get(0); // первый элемент списка - текущий минимум
        int max = nums.get(0); // первый элемент списка - текущий максимум

        // перебираем все числа в списке
        for (int num : nums) {
            sum += num; // добавляем число в общую сумму
            if (num < min) { // если число меньше минимального, то оно становится новым минимумом
                min = num;
            }
            if (num > max) { // если число больше максимального, то оно становится новым максимумом
                max = num;
            }
        }

        double avg = (double) sum / nums.size(); // находим среднее значение

        System.out.println("Минимальное число: " + min);
        System.out.println("Максимальное число: " + max);
        System.out.println("Среднее число: " + avg);
    }
}
