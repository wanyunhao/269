package dierji.synred;

import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.sun.jdi.AbsentInformationException;
import org.apache.commons.collections4.BoundedMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        //list同步  线程安全的list
        List<String> synList = Collections.synchronizedList(list);
        Demo01 demo01 = new Demo01();
        demo01.test();
    }

    private void test() {
    }
}

