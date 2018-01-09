package guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 函数式编程
 * 1. Predicate
 * 2. Function
 */
public class Demo02 {
    public static void main(String[] args) {
        test3();
    }

    /**
     * 组合函数编程 Functions.compose(f1,f2);
     * 确保容器中的字符串长度不超过5,超过进行截取,后全部大写
     */
    public static void test3() {
        List<String> list = Lists.newArrayList("shanghai","good","happiness");

        Function<String,String> f1 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.length() > 5?s.substring(0,5):s;
            }
        };
        Function<String,String> f2 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        //组合2个函数
        Function<String, String> f3 = Functions.compose(f1,f2);

        Collection<String> resultColo = Collections2.transform(list,f3);
        for (String temp:resultColo) {
            System.out.println(temp);
        }
    }

    /**
     * 转换
     */
    public static void test2() {
        Set<Long> timeSet = Sets.newHashSet();
        timeSet.add(10000L);
        timeSet.add(9999999999L);
        timeSet.add(20000000L);
        Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long, String>() {
            @Override
            public String apply(Long aLong) {
                return new SimpleDateFormat("yyyy-MM-dd").format(aLong);
            }
        });

        for (String temp : timeStrCol) {
            System.out.println(temp);
        }
    }

    public static void test1() {
        List<String> list = Lists.newArrayList("moom","son","dad");
        //找出回文palindrome backwords mirror words
        //泛型没有多态
        Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>() {
            @Override
            public boolean apply(String e) {
                //业务逻辑
                return new StringBuilder(e).reverse().toString().equals(e);
            }
        });

        for (String temp : palindromeList) {
            System.out.println(temp);
        }
    }

}

