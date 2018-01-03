package dierji.fangxing;

public class Student<T1,T2> {
    private T1 javase;
    private T2 oracle;

    public T1 getJavase() {
        return javase;
    }

    public void setJavase(T1 javase) {
        this.javase = javase;
    }

    public T2 getOracle() {
        return oracle;
    }

    public void setOracle(T2 oracle) {
        this.oracle = oracle;
    }
}
