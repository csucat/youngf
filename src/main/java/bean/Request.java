package bean;

/**
 * 封装请求信息
 * */
public class Request {

    /**
     * 请求方法
     * */
    private String requestMethod;

    /**
     * 请求路径
     * */
    private String requestPth;

    public Request(String requestMethod, String requestPth) {
        this.requestMethod = requestMethod;
        this.requestPth = requestPth;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestPth() {
        return requestPth;
    }

    public void setRequestPth(String requestPth) {
        this.requestPth = requestPth;
    }
}
