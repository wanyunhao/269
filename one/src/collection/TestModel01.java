package collection;


import java.util.ArrayList;
import java.util.List;

public class TestModel01 {

    public static void main(String[] args) {
        Employee e = new Employee(0301,"高企",3000,"项目部","2017-10");

        //泛型
        List<Employee> list = new ArrayList();
        list.add(e);
        System.out.println(list);

    }

}
