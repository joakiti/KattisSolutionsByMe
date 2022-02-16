import java.util.ArrayList;
import java.util.HashSet;

class MyHashMap {

    ArrayList<KeyMap> myIntegers;
    HashSet<Integer> contains;

    public MyHashMap() {
        myIntegers = new ArrayList<>();
        contains = new HashSet<>();
    }

    public void put(int key, int value) {
        if (contains.contains(key)) {
            myIntegers.removeIf(keyMap -> keyMap.key == key);
        }
        myIntegers.add(new KeyMap(key, value));
        contains.add(key);
    }

    public int get(int key) {
        if (contains.contains(key)) {
            return myIntegers.stream().filter(keyMap -> keyMap.key == key).findFirst().get().value;
        }
        return -1;
    }

    public void remove(int key) {
        myIntegers.removeIf(keyMap -> keyMap.key == key);
        contains.remove(key);
    }
}

class KeyMap {
    int key;
    int value;

    public KeyMap(int key, int value) {
        this.key = key;
        this.value = value;
    }
}