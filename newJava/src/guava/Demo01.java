package guava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
//        List<String> readonlyList = Collections.unmodifiableList(list);
//        readonlyList.add("d");
        //对比 查看  初始化list guava 对只读设置安全可靠 比较简单
        List<String> inmutableList = ImmutableList.of("a","b","c");
        inmutableList.add("d");

    }
}

