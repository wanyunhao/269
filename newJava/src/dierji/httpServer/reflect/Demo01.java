package dierji.httpServer.reflect;

public class Demo01 {
    public static void main(String[] args) {
        String str = "abc";
        Class cls = str.getClass();

        //类.class
        cls = String.class;

        //完整路径
        try {
            cls = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

