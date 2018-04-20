package disanji.javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 测试javassist的Api
 */
public class Demo02 {

    /**
     * 处理类的基本用法
     */
    public static void test01() throws NotFoundException, IOException, CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("disanji.javassist.Emp");

        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
//        System.out.println(cc.getName());
        System.out.println(cc.getSimpleName());



    }

    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("disanji.javassist.Emp");
//        CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}",cc);
        CtMethod m = new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{System.out.println(\"呵呵呵呵呵\");return $1+$2;}");
        cc.addMethod(m);

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();  //调用无参构造 , 实例一个对象
        Method method = clazz.getDeclaredMethod("add",int.class,int.class);
        Object result = method.invoke(obj,200,300);
        System.out.println(result);

    }
    public static void main(String[] args) throws Exception {
//        test01();
        test02();
    }
}

