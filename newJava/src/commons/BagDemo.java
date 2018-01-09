package commons;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

public class BagDemo {
    public static void main(String[] args) {

    }

    /**
     * 无序包
     */
    public static void hashBag() {
        Bag<String> bag = new HashBag<>();
        bag.add("a");
        bag.add("a",5);
        bag.add("a");
    }
}
