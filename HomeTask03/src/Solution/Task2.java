package Solution;

import java.util.ArrayList;
import java.util.Iterator;

/* Задание
Пусть дан произвольный список целых чисел, удалить из него четные числа.
*/
public class Task2 {
    public static void RemoveEvenNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number % 2 == 0) { // если число четное
                iterator.remove(); // удаляем его из списка
            }
        }

        System.out.println(numbers); // выводим список без четных чисел
    }
}