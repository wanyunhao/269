package dierji;

public class MyLinkedList {
    private Node first;
    private Node last;

    private int size;

    public void add(Object o) {
        Node n = new Node();
        if (first == null) {
            n.setPrevious(null);
            n.setObj(o);
            n.setNext(null);
            first = n;
            last = n;
        } else {
            //直接往last节点后增加新的节点
            n.setPrevious(last);
            n.setObj(o);
            n.setNext(null);
            last.setNext(n);
            last = n;

        }
        size++;
    }

    public int size() {
        return size;
    }
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("aaaa");
        list.add("bb");
        list.add("cc");
        System.out.println(list.size());
    }
}
