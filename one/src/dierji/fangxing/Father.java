package dierji.fangxing;

public abstract class Father<T,T1> {

    T name;
    public abstract void test(T t);
}


class Child extends Father<String,Integer>{
    String t2;
    @Override
    public void test(String s) {

    }
}
/*
* 子类为泛型类,类型在使用时确定*/
class Child1<T,T1> extends Father<T,T1> {
    @Override
    public void test(T t) {

    }
}

/*
* 子类为泛型类,父类不指定类型 泛型的擦除 使用Object替换
* */

class Child3<T1,T2> extends Father {
    T1 name2;
    @Override
    public void test(Object o) {

    }
}

/*
* 子类父类同时擦除
* */
class Child4 extends Father {
    @Override
    public void test(Object o) {

    }
}

/*
* 错误: 子类擦除 父类使用泛型
* */

//class Child5 extends Father<T,T1> {
//    @Override
//    public void test(T t) {
//
//    }
//}







