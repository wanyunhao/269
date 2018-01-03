package dierji;

public class MyMap002 {
    Entry[] arr = new Entry[999];
    int size;

    public void put(Object key , Object value) {
        Entry e = new Entry(key, value);
        int a = key.hashCode()%999;
        arr[a] = e;
    }

    public static void main(String[] args) {
        MyMap002 m = new MyMap002();
        m.put("qwe","zxc");
    }
}
