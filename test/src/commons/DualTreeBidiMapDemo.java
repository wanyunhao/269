package commons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

public class DualTreeBidiMapDemo {
    public static void main(String[] args) {
        hashMap();
    }

    /**
     * 有序双向Map
     */
    public static void treeMap() {
        BidiMap<String,String> map = new DualTreeBidiMap<>();
        map.put("1","q");
        map.put("2","w");
        map.put("3","e");
    }

    /**
     * 无序双向Map
     */
    public static void hashMap() {
        BidiMap<String,String> map = new DualHashBidiMap<>();
        map.put("1","q");
        map.put("2","w");
        map.put("3","e");

        //反转
        System.out.println(map.inverseBidiMap().get("q"));
    }
}
