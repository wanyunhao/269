package dierji.paixu;

/**
 * 按价格排序的业务类 (降序)
 */

public class GoodsFavComp implements java.util.Comparator<Goods>{

    @Override
    public int compare(Goods o1, Goods o2) {
        return -(o1.getFav() - o2.getFav());
    }
}
