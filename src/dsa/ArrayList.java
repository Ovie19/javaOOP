package dsa;

public class ArrayList {

    private int size;

    private String[] elements;

    public ArrayList() {
        elements = new String[10];
    }

    public ArrayList(int initialCapacity) {
        elements = new String[initialCapacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Index greater than size");
        return elements[index];
    }

    public boolean add(String element) {
        if (size == elements.length) copyArray();
        elements[size++] = element;
        return false;
    }

    public void add(int index, String element) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Index greater than size");
        if (size == elements.length) copyArray();
        if (index < size) shiftElementRight(index);
        size++;
        elements[index] = element;
    }

    public String remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid Index");

        size--;
        String removedElement = elements[index];
        shiftElementLeft(index);
        return removedElement;
    }

    public boolean remove(String element) {
        int index = indexOf(element);

        boolean elementNotFound = index < 0;
        if (elementNotFound) return false;

        remove(index);
        return true;
    }

    public String set(int index, String element) {
        if (index >= size) throw new IllegalArgumentException("Error!!!");
        String replacedElement = elements[index];
        elements[index] = element;
        return replacedElement;
    }

    public int size() {
        return size;
    }

    public boolean contains(String element) {
        for (int index = 0; index < size; index++)
            if (elements[index].equals(element)) return true;

        return false;
    }

    public void clear() {
        size = 0;
    }

    public int indexOf(String element) {
        for (int index = 0; index < size; index++)
            if (element.equals(elements[index])) return index;

        return -1;
    }

    private void shiftElementRight(int insertionIndex) {
        for (int index = size; index > insertionIndex; index--) {
            elements[index] = elements[index - 1];
        }
    }

    private void shiftElementLeft(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
    }

    private void copyArray() {
        String[] newElements = new String[size * 2];

        System.arraycopy(elements, 0, newElements, 0, size);

        elements = newElements;
    }
}