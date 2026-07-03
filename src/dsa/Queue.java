package dsa;

public class Queue {
    private int count;
    private final String[] elements;

    public Queue(int size) {
        elements = new String[size];
    }

    public boolean add(String element) {
        if  (count == elements.length) throw new IllegalArgumentException("Queue is full");

        return addElement(element);
    }

    public boolean offer(String element) {
        return addElement(element);
    }

    public String remove() {
        if (count == 0) throw new IllegalArgumentException("Queue is empty");
        return removeElement();
    }

    public String poll() {
        if (count == 0) return null;
        return removeElement();
    }

    public String element() {
        if (count == 0) throw new IllegalArgumentException("Queue is empty");
        return elements[0];
    }

    public String peek() {
        return elements[0];
    }

    private void shiftValues() {
        for (int index = 0; index < count; index++) {
            elements[index] = elements[index + 1];
        }
    }

    private boolean addElement(String element) {
        elements[count++] = element;
        return true;
    }

    private String removeElement() {
        String element = elements[0];
        count--;

        shiftValues();
        return element;
    }
}
