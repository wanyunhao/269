package dierji.Refrence;

import java.util.EnumMap;

public class EnumMapDemo {
    public static void main(String[] args) {
        //key必须为枚举
        EnumMap<Season,String> enumMap = new EnumMap<Season, String>(Season.class);
        enumMap.put(Season.Spring,"春困");
    }
}

enum Season {
    Spring,Summer,Autumn,Winter
}
