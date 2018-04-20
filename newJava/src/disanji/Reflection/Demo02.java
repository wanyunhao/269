package disanji.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API,获取类的信息(类的名字,属性,方法,构造器)
 */
public class Demo02 {
    public static void main(String[] args) {
        String path = "disanji.Reflection.testBean.User";
        try {
            Class clszz = Class.forName(path);
            //获取类的名字(全路径) -> disanji.Reflection.testBean.User
            System.out.println(clszz.getName());
            //获得类名 -> User
            System.out.println(clszz.getSimpleName());

            //获取属性信息
//            Field[] f = clszz.getFields(); //只能获得public的属性
            Field[] f = clszz.getDeclaredFields();//获得所有属性
            Field f1 = clszz.getDeclaredField("uname");
            System.out.println(f.length);

            for (Field f2 : f) {
                System.out.println("属性: " + f2);
            }

            //获取方法信息
            Method[] method = clszz.getDeclaredMethods();//public的方法不加Declared
            Method m1 = clszz.getDeclaredMethod("getId",null);
            Method m2 = clszz.getDeclaredMethod("setId", int.class);//如果要传递参数,类型必填,不需要时穿null
            for (Method m :method) {
                System.out.println("方法: " + m);
            }
            //获取构造信息

            Constructor[] constructors = clszz.getDeclaredConstructors();
            //传递不同的参数类型,获得不同的构造方法
            Constructor c1 = clszz.getDeclaredConstructor(int.class,int.class,String.class);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

