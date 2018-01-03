package dierji.fangxing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
//        Student<String,Integer> student = new Student<>();
//        student.setJavase("我的是谁");
//        System.out.println(student.getJavase());
        String string = "my name is wyh wyh is very nice student and is name my";
        String[] strings = string.split(" ");
        Map<String,Letter> letters = new HashMap<String,Letter>();
        for (String temp:strings) {
            if (!letters.containsKey(temp)) {
                Letter letter = new Letter();
                letter.name = temp;
                letter.count = 1;
                letters.put(temp,letter);
            } else {
                Letter letter = letters.get(temp);
                letter.count += 1;
            }
        }

        Set<String> keys = letters.keySet();
        for (String key:keys){
            Letter col = letters.get(key);
            System.out.println("name===" + col.name + "   key==" + col.count);
        }
    }
}

class Letter {
    public int count;
    public String name;

    public Letter() {
    }

    public Letter(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}