package guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * MultiSet:无序 + 可重复
 */
public class MultiSetDemo {
    public static void main(String[] args) {
        String str = "this is a cat and that is a mice where is the food";
        String[] strArray = str.split(" ");
        //存储到MultiSet
        Multiset<String> set = HashMultiset.create();
        for (String temp : strArray) {
            set.add(temp);
        }
        Set<String> letters = set.elementSet();
        for (String temp: letters) {
            System.out.println(temp + "->" + set.count(temp));
        }
    }


}

