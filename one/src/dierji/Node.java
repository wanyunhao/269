package dierji;

public class Node {
    private Object previous;
    private Object obj;
    private Object next;

    public Node() {

    }

    public Object getPrevious() {
        return previous;
    }

    public Object getObj() {
        return obj;
    }

    public Object getNext() {
        return next;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setNext(Object next) {
        this.next = next;
    }
}
