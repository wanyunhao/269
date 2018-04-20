package disanji.Reflection;

import disanji.Reflection.testBean.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 反射获取泛型
 */
public class Demo04 {


    public void test01(Map<String,User> map, List<User> list) {

    }

    public Map<Integer,User> test02 () {
        return null;
    }


    public static void main(String[] args) {
        try {
            //使用反射获取泛型参数
            Method method = Demo04.class.getDeclaredMethod("test01", Map.class, List.class);
            Type[] types = method.getGenericParameterTypes();
            for (Type paramType :types) {
                System.out.println("#" + paramType);
                if (paramType instanceof ParameterizedType) {
                    Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                    for (Type genericType : genericTypes) {
                        System.out.println("泛型类型: " + genericType);
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

