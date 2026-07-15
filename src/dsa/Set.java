package dsa;

public class Set {

    private final ArrayList elements =  new ArrayList();

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() { return elements.size(); }

    public boolean add(String element) {
        if (contains(element)) return false;

        elements.add(element);
        return true;
    }

    public boolean remove(String element) {
        return elements.remove(element);
    }

    public boolean contains(String element) {
        return elements.contains(element);
    }

    public int indexOf(String element) {
        return elements.indexOf(element);
    }

    public void clear() {
        elements.clear();
    }
}
