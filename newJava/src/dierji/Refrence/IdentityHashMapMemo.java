package dierji.Refrence;

import java.util.IdentityHashMap;

public class IdentityHashMapMemo {
    public static void main(String[] args) {
        IdentityHashMap<String,String> map = new IdentityHashMap<String,String>();
        //常量池中的"a"
        map.put("a","a1");
        map.put("a","a2");
        //比较地址
        map.put(new String("a"),"a3");
        System.out.println(map.size());
    }
}
