package commons;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.list.PredicatedList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class transformerDemo {
    public static void main(String[] args) {
        custormChange();
    }

    public static void custormChange() {
        //判别式
        Predicate<Employee> predicate = new Predicate<Employee>() {
            @Override
            public boolean evaluate(Employee employee) {
                return employee.getSalary() > 0;
            }
        };

        Predicate notNull = NotNullPredicate.notNullPredicate();
        Predicate allPredicate = PredicateUtils.allPredicate(predicate,notNull);
        List<Employee> list = PredicatedList.predicatedList(new ArrayList<Employee>(),allPredicate);

        list.add(new Employee("网易",10000));
        list.add(new Employee("百度",20000));
        list.add(new Employee("阿里",30000));
        list.add(new Employee("腾讯",40000));

        Transformer<Employee,Level> transformer = new Transformer<Employee, Level>() {
            @Override
            public Level transform(Employee employee) {
                Level level = new Level();
                level.setName(employee.getName());
                if (employee.getSalary() >= 10000) {
                    level.setLevel("1");
                }
                if (employee.getSalary() >= 20000) {
                    level.setLevel("2");
                }
                if (employee.getSalary() >= 30000) {
                    level.setLevel("3");
                }
                if (employee.getSalary() >= 40000) {
                    level.setLevel("4");
                }
                return level;
            }
        };
        Collection<Level> levelCollection = CollectionUtils.collect(list,transformer);
        for (Level level : levelCollection) {
            System.out.println(level.toString());
        }

    }

    /**
     * 内置类型的转化
     */
    public static void inner() {
        System.out.println("内置类型转换,长整型时间日期,转成指定格式字符串");
        //类型转换器
        Transformer<Long,String> transformer = new Transformer<Long, String>() {
            @Override
            public String transform(Long aLong) {
                return new SimpleDateFormat("yyyy-MM-dd").format(aLong);
            }
        };


        List<Long> list = new ArrayList<Long>();
        list.add(99911111111111111L);
        list.add(9990000L);

        //工具类
        Collection<String> collection = CollectionUtils.collect(list,transformer);
        for (String time: collection) {
            System.out.println(time);
        }
    }
}

