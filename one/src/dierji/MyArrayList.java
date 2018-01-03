package dierji;

/*
* 自己实现ArrayList
*
* */
public class MyArrayList {

    private Object[] elementData;

    private int size;

    public MyArrayList () {
        this(10);
    }

    public MyArrayList (int initialCapacity) {
        if (initialCapacity < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData = new Object[initialCapacity];
    }

    public int size1() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(Object obj) {
        //数组扩容和数据的拷贝
        if (size == elementData.length) {
            Object[] newArray = new Object[size * 2 + 1];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        elementData[size ++] = obj;

    }

    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }
    /*
    * 删除
    */
    public void remove(int index) {
        rangeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work

    }

    public void remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    remove(index);
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    remove(index);
                }
        }

    }


    public void set(int index, Object o) {
        rangeCheck(index);
        elementData[index] = o;
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(3);
        list.add(123);
        list.add(321);
        list.add(456);
        list.add("789");
        list.remove("789");
        list.set(1,"委员会");
        for (int i = 0;i < list.size; i++) {
            System.out.println(list.get(i));
        }


    }

    private void rangeCheck(int index) {
        if (index >= size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }
}
