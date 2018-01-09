package commons;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CollectionDemo {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set1.add(2);
        set1.add(3);
        set1.add(4);

        //并集
        Collection<Integer> col = CollectionUtils.union(set1,set2);
        for(Integer integer : col) {
            System.out.println(integer);
        }

//        //交集
//        Collection<Integer> col1 = CollectionUtils.retainAll(set1,set2);
//        for(Integer integer : col1) {
//            System.out.println(integer);
//        }

        //差集
        Collection<Integer> col2 = CollectionUtils.subtract(set1,set2);
        for(Integer integer : col2) {
            System.out.println(integer);
        }
    }
}
