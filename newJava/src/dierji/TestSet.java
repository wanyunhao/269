package dierji;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("123");
        set.add("456");
        set.add("789");
        set.add("789");
        int i = 0;
        while (i < set.size()) {
            i++;
            System.out.println(set);
        }

    }
}
