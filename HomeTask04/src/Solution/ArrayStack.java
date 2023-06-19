package Solution;

/*
Задание4(со звездочкой)
Реализовать стэк с помощью массива.
Нужно реализовать методы: size(), empty(), push(), peek(), pop().
*/
public class ArrayStack<E> {


    public E[] stack;
    private int size;

    public ArrayStack(int capacity) {
        this.stack = (E[]) new Object[capacity];
        this.size = 0;
    }

    // Метод возвращает количество элементов на стеке
    public int size() {
        return size;
    }

    // Метод возвращает true, если стек пуст
    public boolean empty() {
        return size == 0;
    }

    // Метод добавляет элемент на вершину стека
    public void push(E element) {
        if (size == stack.length) {
            throw new StackOverflowError();
        }
        stack[size++] = element;
    }

    // Метод возвращает элемент на вершине стека без удаления его из стека
    public E peek() {
        if (empty()) {
            throw new IllegalStateException("Stack пуст");
        }
        return stack[size - 1];
    }

    // Метод удаляет элемент на вершине стека и возвращает его значение
    public E pop() {
        if (empty()) {
            throw new IllegalStateException("Stack пуст");
        }
        E result = stack[--size];
        stack[size] = null;
        return result;
    }
}