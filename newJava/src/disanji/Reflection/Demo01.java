package disanji.Reflection;

/**
 * java.lang.Class的获取方法
 */
public class Demo01 {
    public static void main(String[] args) {
        String path = "disanji.Reflection.testBean.User";
        try {

            Class clszz = Class.forName(path);
            System.out.println(clszz);
            //对象表示一些封装的数据.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

