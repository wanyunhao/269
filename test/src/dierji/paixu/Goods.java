package dierji.paixu;


public class Goods{
    private String name;
    private Double price;
    private int fav;

    public Goods() {
    }

    public Goods(String name, Double price, int fav) {
        this.name = name;
        this.price = price;
        this.fav = fav;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    @Override
    public String toString() {
        return "商品名称:" + this.name + "  " + "收藏量:" + this.fav + "  " + "价格:" + this.price + "\n";
    }


}
