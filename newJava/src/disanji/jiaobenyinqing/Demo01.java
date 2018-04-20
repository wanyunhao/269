package disanji.jiaobenyinqing;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 测试脚本引擎执行js
 */
public class Demo01 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        //获取脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        //定义变量,存储到引擎上下文中
        engine.put("msg","gaoqi is good");
        String str = "var user = {name:'gaoqi',age:18,schools:['清华','北大']};";

        str += "print(user.name);";

        engine.eval(str);

        engine.eval("msg = 'sxt is good'");
        System.out.println(engine.get("msg"));

        System.out.println("##########################################");


        //定义函数
        engine.eval("function add(a,b) {return a + b}");

        //取得调用接口
        Invocable jsInvoke = (Invocable)engine;

        //执行脚本中定义方法
        Object object = jsInvoke.invokeFunction("add",new Object[]{13,20});
        System.out.println(object);

        //导入其他的Java包,使用其他包的类
//        String jsCode = "importPackage(java.util); var list=Arrays.asList([\"上海灿谷\",\"上海大学\"]);";
//        engine.eval(jsCode);
//
//        List<String> list = (List<String>) engine.get("list");
//        for (String temp:list) {
//            System.out.println(temp);
//        }

        //执行一个js文件(我们将a.js至于src下)

        URL url = Demo01.class.getClassLoader().getResource("disanji/jiaobenyinqing/a.js");
        //FileReader fr = new FileReader("src/disanji/jiaobenyinqing/a.js");
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close();

    }
}

