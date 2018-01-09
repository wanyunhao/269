package commons;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

//139集
public class ClosureDemo {
    public static void main(String[] args) {
//        whileClosureTest();
        chainTest();
    }

    /**
     * 折上减 先打折商品进行9折, 满百减20
     */
    public static void chainTest() {
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("javase video",1200,true));
        list.add(new Goods("oc video",90,false));
        list.add(new Goods("python video",3600,true));

        //满百减20
        Closure<Goods> subtract = new Closure<Goods>() {
            @Override
            public void execute(Goods goods) {
                int hundred = (int) (goods.getPrice() / 100);
                goods.setPrice(goods.getPrice() - hundred * 20);
            }
        } ;
        //打九折
        Closure<Goods> percent = new Closure<Goods>() {
            @Override
            public void execute(Goods goods) {
                if (goods.isDiscount()){
                    goods.setPrice(goods.getPrice() * 0.9);
                }

            }
        };

        //链式操作
        Closure<Goods> hainedClosure = ChainedClosure.chainedClosure(percent,subtract);
        CollectionUtils.forAllDo(list,hainedClosure);
        for (Goods goods: list) {
            System.out.println(goods.toString());
        }
    }


    /**
     * 确保所有员工工资超过一万  如果超过 不管
     */
    public static void whileClosureTest() {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("网易",10000));
        list.add(new Employee("百度",20000));
        list.add(new Employee("阿里",30000));
        list.add(new Employee("腾讯",40000));

        //业务功能
        Closure<Employee> closure = new Closure<Employee>() {
            @Override
            public void execute(Employee employee) {
                employee.setSalary(employee.getSalary() * 1.2);
            }
        };

        //判断是否超过20000
        Predicate<Employee> predicate = new Predicate<Employee>() {
            @Override
            public boolean evaluate(Employee employee) {
                return employee.getSalary() > 20000;
            }
        };

        Closure<Employee> whileClosure = WhileClosure.whileClosure(predicate,closure,false);
//        //工具类
        CollectionUtils.forAllDo(list,whileClosure);
//        System.out.println(123);
//        Iterator<Employee> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
    /**
     * 二选一操作 如果打折商品进行9折, 否则满百减20
     */
    public static void ifClosureTest() {
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("javase video",1200,true));
        list.add(new Goods("oc video",90,false));
        list.add(new Goods("python video",3600,true));

        //满百减20
        Closure<Goods> subtract = new Closure<Goods>() {
            @Override
            public void execute(Goods goods) {
                int hundred = (int) (goods.getPrice() / 100);
                goods.setPrice(goods.getPrice() - hundred * 20);
            }
        } ;
        //打九折
        Closure<Goods> percent = new Closure<Goods>() {
            @Override
            public void execute(Goods goods) {
                goods.setPrice(goods.getPrice() * 0.9);
            }
        };

        Predicate<Goods> predicate = new Predicate<Goods>() {
            @Override
            public boolean evaluate(Goods goods) {
                return goods.isDiscount();
            }
        };

        //二选一
        Closure<Goods> ifClosure = IfClosure.ifClosure(predicate,percent,subtract);
        CollectionUtils.forAllDo(list,ifClosure);
        for (Goods goods: list) {
            System.out.println(goods.toString());
        }
    }

    /**
     * 基本操作
     */

    public static void basic() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("网易",10000));
        list.add(new Employee("百度",20000));
        list.add(new Employee("阿里",30000));
        list.add(new Employee("腾讯",40000));

        //业务功能  所有工资涨0.2
        Closure<Employee> closure = new Closure<Employee>() {
            @Override
            public void execute(Employee employee) {
                employee.setSalary(employee.getSalary() * 1.2);
            }
        };

        //工具类
        CollectionUtils.forAllDo(list,closure);
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
