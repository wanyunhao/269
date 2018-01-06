package guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

public class MultimapDemo {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("改革开放", "邓");
        map.put("三个代表", "小");
        map.put("发财致富", "平");
        map.put("八荣八耻", "胡静");
        map.put("八荣八耻2", "胡静");

        Multimap<String, String> teachers = ArrayListMultimap.create();
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            teachers.put(value,key);
        }
        Set<String> keySet = teachers.keySet();
        for (String key: keySet) {
            Collection<String> col = teachers.get(key);
            System.out.println(key + "->" + col);
        }
    }
}

