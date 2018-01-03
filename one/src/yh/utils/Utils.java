package yh.utils;

import java.util.List;

public class Utils {
    /*
    * 容器排序, 使用泛型方法
    * */
    public static <T extends Comparable<T>> void sort(List<T> list) {
        Object[] arr = list.toArray();
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            list.set(i, (T) arr[i]);
        }
    }

    /*
    * 数组排序使用泛型
    * */

    public static <T extends Comparable<T>> void sort(T[] arr) {
        boolean sorted = true;
        for (int j = 0; j < arr.length - 1; j++) {
            sorted = true;
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (((Comparable)arr[i]).compareTo(arr[i + 1]) < 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }
    /*
    * 数组的排序(降序)
    * */
    public static void sort(Object[] arr) {
        boolean sorted = true;
        for (int j = 0; j < arr.length - 1; j++) {
            sorted = true;
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (((Comparable)arr[i]).compareTo(arr[i + 1]) < 0) {
                    Object temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }
}
