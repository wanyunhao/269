package dierji.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo01 {
    public static void main(String[] args) {
        List<Integer> cards = new ArrayList<Integer>();
//        integerList.add(1);
//        integerList.add(2);
//        integerList.add(3);
//        integerList.add(4);
//        System.out.println(integerList);
//        Collections.reverse(integerList);
//        System.out.println(integerList);
//        Collections.shuffle(integerList);
        for (int i = 0; i < 54; i++) {
            cards.add((i + 1));
        }
        Collections.shuffle(cards);
        List<Integer> p1 = new ArrayList<Integer>();
        List<Integer> p2 = new ArrayList<Integer>();
        List<Integer> p3 = new ArrayList<Integer>();
        List<Integer> last = new ArrayList<Integer>();
        for (int i = 0; i < 51; i += 3) {
            p1.add(cards.get(i));
            p2.add(cards.get(i + 1));
            p3.add(cards.get(i + 2));
        }

        last.add(cards.get(51));
        last.add(cards.get(52));
        last.add(cards.get(53));
        System.out.println("第1个人: " + p1);
        System.out.println("第2个人: " + p2);
        System.out.println("第3个人: " + p3);
        System.out.println("底牌: " + last);

    }
}
