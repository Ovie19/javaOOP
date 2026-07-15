package dsa;

public class Queue {
    private int count;
    private int currentIndex;
    private int lastPosition;
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
        return elements[currentIndex];
    }

    public String peek() {
        return elements[currentIndex];
    }

    private boolean addElement(String element) {
        if (lastPosition == elements.length)
            shiftValues();

        lastPosition++;
        elements[count++] = element;
        return true;
    }

    private String removeElement() {
        String element = elements[currentIndex++];
        count--;
        return element;
    }

    private void shiftValues() {
        for (int index = 0; index < count; index++) {
            elements[index] = elements[currentIndex + index];
        }
        lastPosition -= currentIndex;
        currentIndex = 0;
    }
}
