package dierji.httpServer.demo02;

public class RegisterServlet extends Servlet {

    @Override
    public void doGet(Request request, Response response) throws Exception {

    }

    @Override
    public void doPost(Request request, Response response) throws Exception {
        response.println("<html>" +
                "<head>" +
                "<title>注册</title>" +
                "</head><body>");
        response.println(request.getParamter("user"));
        response.println("</body></html>");
    }
}

