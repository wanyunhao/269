package guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Set;

public class TableDemo {
    public static void main(String[] args) {
        Table<String,String,Integer> table = HashBasedTable.create();
        //测试数据
        table.put("a","javase",20);
        table.put("b","javaee",30);
        table.put("c","OC",40);
        Set<Table.Cell<String,String,Integer>> cells = table.cellSet();
        for (Table.Cell<String,String,Integer> temp:
             cells) {
            System.out.println(temp.getColumnKey());
            System.out.println(temp.getRowKey());
        }

    }
}
