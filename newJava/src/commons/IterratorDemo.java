package commons;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterratorDemo {
    public static void main(String[] args) {
//        mapIt();
//        quChongIt();
//        filterIt();
//        loopIt();
        arrayIt();
    }

    /**
     * 数组迭代器
     */
    public static void arrayIt() {
        int[] ints = {1,2,3,4,5};
        //指定起始索引  结束索引
        Iterator<Integer> it = new ArrayListIterator<>(ints,1,3);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * 循环迭代器
     */
    public static void loopIt() {
        List<String> list = new ArrayList<>();
        list.add("rad");
        list.add("dad");
        list.add("moom");


        Iterator<String> iterator = new LoopingIterator<>(list);
        for (int i = 0; i < 5; i++) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 自定义迭代器
     */
    public static void filterIt() {
        List<String> list = new ArrayList<>();
        list.add("rad");
        list.add("dad");
        list.add("moom");

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String s) {
                return new StringBuilder(s).reverse().toString().equals(s);
            }
        };

        Iterator<String> iterator = new FilterIterator<>(list.iterator(),predicate);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 去重迭代器
     */
    public static void quChongIt() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");

        Iterator<String> iterator = new UniqueFilterIterator<>(list.iterator());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * map迭代器
     */
    public static void mapIt() {
        IterableMap<String,String> map = new HashedMap<>();
        map.put("a","shanghai");
        map.put("b","bj");
        map.put("c","hz");

        MapIterator<String,String> iterator = map.mapIterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = iterator.getValue();
            System.out.println("key==" + key + " value==" + value);
        }
    }
}
