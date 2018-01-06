package guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.HashMap;

/**
 * HashMap 键唯一 值可以重复
 * BiMap 双向Map键和值都不能重复  根据value 找key
 */
public class BiMapDemo {
    public static void main(String[] args) {
        BiMap<String ,String> biMap = HashBiMap.create();
        biMap.put("123","456");
        biMap.put("123","456");
        biMap.put("123","456");

        String user = biMap.inverse().get("456");
    }
}

