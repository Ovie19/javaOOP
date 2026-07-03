package dsa;

public class Stack {
    private int count;
    private final String[] elements;

    public Stack(int size) {
        elements = new String[size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(String element) {
        if  (isFull()) throw new IllegalArgumentException("Stack is full");
        elements[count++] = element;
    }

    private boolean isFull() {
        return count == elements.length;
    }

    public String pop() {
        if (count == 0) throw new IllegalArgumentException("Stack is empty");
        return elements[--count];
    }

    public String peek() {
        return elements[count - 1];
    }
}
