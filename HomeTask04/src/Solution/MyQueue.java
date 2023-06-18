package Solution;

import java.util.Arrays;
import java.util.LinkedList;

public class MyQueue<T> {
    private LinkedList<T> queue = new LinkedList<>();

    // помещает элемент в конец очереди
    public void enqueue(T element) {
        queue.addLast(element);
    }

    // возвращает первый элемент из очереди и удаляет его,
    public T dequeue() {
        return queue.removeFirst();
    }

    // возвращает первый элемент из очереди, не удаляя.
    public T first() {
        return queue.getFirst();
    }
}