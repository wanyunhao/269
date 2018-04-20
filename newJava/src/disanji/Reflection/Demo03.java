package disanji.Reflection;

import disanji.Reflection.testBean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API动态的操作:构造器,方法,属性
 * javaBean 必须要无参构造
 */
public class Demo03 {
    public static void main(String[] args) {

        String path = "disanji.Reflection.testBean.User";
        try {
            Class<User> clszz = (Class<User>) Class.forName(path);

            //通过反射API调用构造方法,构造对象
            User user = clszz.newInstance();//其实是调用了User的无参构造
            System.out.println(user);

            Constructor<User> c = clszz.getDeclaredConstructor(int.class,int.class,String.class);
            User user1 = c.newInstance(1001,18,"wyh");

            System.out.println(user1.getUname());

            //通过反射API调用普通方法
            User user2 = clszz.newInstance();
            Method method = clszz.getDeclaredMethod("setUname", String.class);
            method.invoke(user2,"wyh3");

            //通过反射API操作属性
            User user3 = clszz.newInstance();
            Field field = clszz.getDeclaredField("uname");
            field.setAccessible(true);//这个属性不用做安全检查 private可以访问
            field.set(user3,"吴彦祖");
            System.out.println(user3.getUname());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

