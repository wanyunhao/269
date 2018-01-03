package dierji.treeSetAndTreeMap;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Person p1 = new Person("我",100);
        Person p2 = new Person("刘德华",50);
        Person p3 = new Person("梁超凡",40);
        Person p4 = new Person("吴彦祖",100);
        //依次存放到treeSet容器中
        TreeSet<Person> peoples = new TreeSet<Person>(new PersonCompare());
        peoples.add(p1);
        peoples.add(p2);
        peoples.add(p3);
        peoples.add(p4);
        System.out.println(peoples.toString());
    }
}

class PersonCompare implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return -(o1.getHandsome() - o2.getHandsome());
    }
}