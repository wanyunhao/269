package dierji.httpServer.demo01;

public class Servlet {
    public void servlet(Request request,Response response) {

        response.println("<html>" +
                "<head>" +
                "<title>1象印</title>" +
                "</head><body>");
        response.println(request.getParamter("user"));
        response.println("</body></html>");
    }

}

