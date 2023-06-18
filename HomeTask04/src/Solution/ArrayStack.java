package Solution;

public class ArrayStack<E> {

    /*
    Задание
    4(со звездочкой) Реализовать стэк с помощью массива.
    Нужно реализовать методы: size(), empty(), push(), peek(), pop().
     */
    public E[] stack;
    private int size;

    public ArrayStack(int capacity) {
        this.stack = (E[]) new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(E element) {
        if (size == stack.length) {
            throw new StackOverflowError();
        }
        stack[size++] = element;
    }

    public E peek() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[size - 1];
    }

    public E pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E result = stack[--size];
        stack[size] = null; // clear the reference to the popped element
        return result;
    }
}