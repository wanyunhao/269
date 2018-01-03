package Iterator;

import java.util.*;

public class Test01 {

    public static void main(String[] args) {

//        List list = new ArrayList();
//        list.add("aa");
//        list.add("bb");
//        list.add("cc");
//        System.out.println(list.iterator());

        Set set = new HashSet();
        set.add("高一");
        set.add("高二");
        set.add("高三");

        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            String string = (String) iter.next();
            System.out.println(string);
        }

//        for (Iterator iterator = set.iterator();iterator.hasNext();) {
//            String string = (String) iterator.next();
//            System.out.println(string);
//        }
    }
}
