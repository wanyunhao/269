package dierji.iterator;

import java.util.*;

public class Test01 {


    public static void main(String[] args) {
//        List list = new ArrayList();
//        list.add("aaa");
//        list.add("bbb");
//        list.add("ccc");
//        for (int i = list.iterator();i<1;) {
//
//        }
        Set set = new HashSet();
        set.add("high one");
        set.add("high two");
        set.add("high three");
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            String str = (String)iterator.next();
//            System.out.println(str);
//        }
        for (Iterator iterator1 = set.iterator();iterator1.hasNext();) {
            System.out.println(iterator1.next());
        }
    }
}
