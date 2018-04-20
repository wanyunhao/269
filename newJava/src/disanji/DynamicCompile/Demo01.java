package disanji.DynamicCompile;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Demo01 {
    public static void main(String[] args) {
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        compiler.run(null,null,null,"路径");

        try {
            URL[] urls = new URL[]{new URL("file:/"+"/Users/wanyunhao/Documents/myjava/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("qqq");

            Method m = c.getMethod("main",String[].class);
            //静态方法不需要穿obj  直接null main 是静态方法
            //由于可变参数
            m.invoke(null,new String[]{});


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

