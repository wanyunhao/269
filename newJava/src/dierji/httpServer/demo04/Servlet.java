package dierji.httpServer.demo04;

public abstract class Servlet {
    public void servlet(Request request, Response response) throws Exception {
        this.doGet(request,response);
        this.doPost(request,response);

    }

    public abstract void doGet(Request request, Response response) throws Exception;
    public abstract void doPost(Request request, Response response) throws Exception;

}

