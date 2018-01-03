package dierji;

public class MyMap001 {

    Entry[] arr = new Entry[990];
    int size;
    public void put(Object key, Object value) {
        for (int i = 0;i < size; i++) {
            if (arr[i].key.equals(key)) {
                arr[i].value = value;
                return;
            }
        }
        Entry e = new Entry(key,value);
        arr[size++] = e;
    }

    public Object get(Object key) {
        for (int i = 0;i < size;i++) {
            Entry e = arr[i];
            if (e.key.equals(key)){
                return e.value;
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        for (int i = 0;i < size; i++) {
            if (arr[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyMap001 map = new MyMap001();
        map.put("qwe","asd");
        System.out.println(map.containsKey("qwe"));
    }
}

class Entry {
    Object key;
    Object value;

    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}