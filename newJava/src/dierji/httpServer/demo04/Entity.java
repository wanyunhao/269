package dierji.httpServer.demo04;

/**
 <servlet>
 <servlet-name>login</servlet-name>
 <servlet-class>dierji.httpServer.demo04.LoginServlet</servlet-class>
 </servlet>
 */
public class Entity {
    private String name;
    private String cls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }
}

