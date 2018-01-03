package dierji.paixu;

import yh.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class App {
    public static void main(String[] args) {
//        int[] count = {1,5,4,3,2};
//        String[] strings = {"123","145"};
//        Utils.sort(strings);
//        sort1(count);
        //冒泡最终版
//        sort2(count);
//        System.out.println(Arrays.toString(strings));
        /*
        * 标题:中国时间:2018-01-03 15:40:48点击量:100
        , 标题:美国时间:2018-01-03 15:41:38点击量:50
        , 标题:俄罗斯时间:2018-01-03 15:39:58点击量:100
        , 标题:英国时间:2018-01-03 15:42:28点击量:200
        , 标题:澳大利亚时间:2018-01-03 15:41:38点击量:300
]
        * */
//        List<NewsItem> list = new ArrayList<NewsItem>();
//        list.add(new NewsItem(new Date(),100,"中国"));
//        list.add(new NewsItem(new Date(System.currentTimeMillis() + 1000 * 50),50,"美国"));
//        list.add(new NewsItem(new Date(System.currentTimeMillis() - 1000 * 50),100,"法国"));
//        list.add(new NewsItem(new Date(System.currentTimeMillis() + 1000 * 100),200,"英国"));
//        list.add(new NewsItem(new Date(System.currentTimeMillis() + 1000 * 50),300,"德国"));
//
//        System.out.println("排序前:" + "\n" +list.toString());
//        Collections.sort(list);
//        System.out.println("排序后:" + "\n" +list.toString());

        List<Goods> list = new ArrayList<Goods>();
        list.add(new Goods("电脑",7999.89,11998));
        list.add(new Goods("手机",16888.89,1998));
        list.add(new Goods("电视",15777.89,38));
        list.add(new Goods("空调",4666.89,3998));

        System.out.println("排序前:" + "\n" +list.toString());
        Collections.sort(list,new GoodsFavComp());
        System.out.println("排序后:" + "\n" +list.toString());
    }



//    static void sort2(int[] arr) {
//        boolean sorted = true;
//        for (int j = 0; j < arr.length; j++) {
//            sorted = true;
//            for (int i = 0; i < arr.length - 1 - j; i++) {
//                if (arr[i] < arr[i + 1]) {
//                    int temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//                    sorted = false;
//                }
//            }
//            if (sorted) {
//                break;
//            }
//        }
//    }
//
//
//    public static void sort1(int[] count) {
//        for (int j = 0; j < count.length; j++) {
//            System.out.println("第" + (j + 1) + "趟");
//            for (int i = 0; i < count.length - 1 - j; i++) {
//                System.out.println("第" + (i + 1) + "次");
//                if (count[i] < count[i + 1]) {
//                    int temp = count[i];
//                    count[i] = count[i + 1];
//                    count[i + 1] = temp;
//                }
//            }
//        }
//    }
}
