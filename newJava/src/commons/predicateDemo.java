package commons;


import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;

import java.util.ArrayList;
import java.util.List;

public class predicateDemo {
    public static void main(String[] args) {
        custom();
    }

    /**
     * 自定义判断
     */
    public static void custom() {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String s) {
                return s.length() > 5 && s.length() < 20;
            }
        };

        Predicate notNull = NotNullPredicate.notNullPredicate();

        Predicate all = PredicateUtils.allPredicate(predicate,notNull);

        List<String> list = PredicatedList.predicatedList(new ArrayList<String>(),all);
        list.add(null);

    }
    /**
     * 判断唯一
     */
    public static void only() {
        Predicate<Long> uniquePre = UniquePredicate.uniquePredicate();
        List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(),uniquePre);
        list.add(100L);
//        list.add(100L);

    }

    /**
     * 判断相等
     */
    public static void equal() {
        Predicate<String> predicate = new EqualPredicate<String>("shanghai");
        boolean flag = predicate.evaluate("shanghai");
        System.out.println(flag);
    }

    /**
     * 判断非空
     */
    public static void notNull() {
        Predicate notNull = NotNullPredicate.notNullPredicate();
        notNull.evaluate("123");//非空为true  否则为false

        //添加容器值得判断
        List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(),notNull);
        list.add(1000L);
        //加了非空的条件  不允许为空
//        list.add(null);
    }

}
