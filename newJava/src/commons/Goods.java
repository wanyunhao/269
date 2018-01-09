package commons;

public class Goods {
    private String name;
    private double price;
    //折扣
    private boolean discount;

    public Goods() {

    }

    public Goods(String name, double price, boolean discount) {

        this.name = name;
        this.price = price;
        this.discount = discount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "名称=" + name + '\'' + "价格=" + price + "是否打折=" + (discount?"是":"否");
    }
}
