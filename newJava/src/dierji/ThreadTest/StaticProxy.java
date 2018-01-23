package dierji.ThreadTest;

public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        WeddingCompany wc = new WeddingCompany(you);
        wc.marry();
    }

}

interface Marry {
    void marry();
}

class You implements Marry {
    @Override
    public void marry() {
        System.out.println("我结婚");
    }
}

//代理角色
class WeddingCompany implements Marry {
    private Marry you;

    public WeddingCompany(Marry you) {
        this.you = you;
    }

    private void before() {
        System.out.println("房子");
    }

    private void after() {
        System.out.println("闹洞房");
    }

    @Override
    public void marry() {
        before();
        you.marry();
        after();
    }
}