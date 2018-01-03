package dierji.treeSetAndTreeMap;

import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetDemo02 {
    public static void main(String[] args) {
        Worker w1 = new Worker("农民工",12345.99);
        Worker w2 = new Worker("程序员",25000.32);
        Worker w3 = new Worker("老师",5000);
        TreeSet<Worker> workerTreeSet = new TreeSet<Worker>();
        workerTreeSet.add(w1);
        workerTreeSet.add(w2);
        workerTreeSet.add(w3);
        System.out.println(workerTreeSet.toString());
    }
}
