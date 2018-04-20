package dierji.httpServer.demo04;

public class LoginServlet extends Servlet {
    public static void main(String[] args) {

    }


    @Override
    public void doGet(Request request, Response response) throws Exception {
        String name = request.getParamter("user");
        String pwd = request.getParamter("pwd");
        response.println("<html>" +
                "<head>" +
                "<title>登录</title>" +
                "</head><body>");
        if (login(name,pwd)){
            response.println(request.getParamter("user"));
        } else {
            response.println("账号密码错误");
        }
        response.println("</body></html>");

    }

    public boolean login(String name,String pwd) {
        return name.trim().equals("wyh") && pwd.trim().equals("1");
    }

    @Override
    public void doPost(Request request, Response response) throws Exception {

    }
}

