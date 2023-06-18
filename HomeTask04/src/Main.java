import Solution.ArrayStack;
import Solution.Calculator;
import Solution.LinkedListReverser;
import Solution.MyQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем исходный список
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(56, 34, 222, 342, 555));
        System.out.println("Исходный список: " + list);

        // Создаем объект Task1
        LinkedListReverser task = new LinkedListReverser();

        // Получаем перевернутый список
        LinkedList<Integer> reversedList = task.reverseLinkedList(list);
        System.out.println("Перевернутый список: " + reversedList);

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("раз");
        queue.enqueue("два");
        queue.enqueue("три");

        System.out.println(queue.first()); // "раз"
        System.out.println(queue.dequeue()); // "раз"
        System.out.println(queue.first()); // "два"

        // Создаем новый стек с начальной емкостью 5.
        ArrayStack<Integer> stack = new ArrayStack<>(9);

        // Добавляем элементы в стек
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        // Выводим текущее количество элементов в стеке
        System.out.println("Size: " + stack.size());

        // Проверяем, является ли стек пустым
        System.out.println("Empty: " + stack.empty());

        // Выводим верхний элемент стека
        System.out.println("Peek: " + stack.peek());

        // Удаляем верхний элемент стека
        stack.pop();

        // Выводим все элементы стека
        System.out.println("Stack: " + Arrays.toString(stack.stack));
    }
}