package dsa;

public class Map {

    private final Set keys = new Set();
    private final ArrayList values = new ArrayList();

    public boolean isEmpty() {
        return keys.isEmpty();
    }

    public int size() {
        return keys.size();
    }

    public String put(String key, String value) {
        boolean keyExists = keys.contains(key);
        if (keyExists) {
            int index = keys.indexOf(key);
            String oldValue = values.get(index);
            values.set(index, value);
            return oldValue;
        }

        keys.add(key);
        values.add(value);
        return null;
    }

    public String get(String key) {
        if (!containsKey(key)) return null;

        int keyIndex = keys.indexOf(key);
        return values.get(keyIndex);
    }

    public String remove(String key) {
        if (!containsKey(key)) return null;

        int keyIndex = keys.indexOf(key);
        keys.remove(key);
        return values.remove(keyIndex);
    }

    public boolean containsKey(String key) {
        return keys.contains(key);
    }

    public boolean containsValue(String value) {
        return values.contains(value);
    }

    public void clear() {
        keys.clear();
        values.clear();
    }
}
