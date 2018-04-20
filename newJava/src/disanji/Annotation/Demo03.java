package disanji.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解信息,模拟处理注解信息的流程
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("disanji.Annotation.Student");

            //获得类的所有有效注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a :
                    annotations) {
                System.out.println(a);
            }
            //获得类的指定的注解
            Table table = (Table) clazz.getAnnotation(Table.class);
            System.out.println(table.value());

            //获得类的属性注解
            Field field = clazz.getDeclaredField("studentName");
            disanji.Annotation.Field field1 = field.getAnnotation(disanji.Annotation.Field.class);
            System.out.println(field1.columnName() + "--" + field1.type() + "--" + field1.length());

            //根据获得的表名  字段 拼出DBL语句 然后使用JDBC执行这个SQL,在数据库中生成



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

