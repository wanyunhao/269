package dierji.Refrence;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String ,String> weakHashMap = new WeakHashMap<String ,String>();
        //常量池对象,不会回收
        weakHashMap.put("abcdef","a");
        weakHashMap.put("qwe","b");
        //gc运行 已被回收
        weakHashMap.put(new String("shanghai"),"a");
        weakHashMap.put(new String("shanghai"),"a");

        //通知回收
        System.gc();
        System.runFinalization();

        System.out.println(weakHashMap.size());
    }
}
