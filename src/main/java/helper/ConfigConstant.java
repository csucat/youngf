package helper;


/**
 * 维护配置文件中相关的配置项名称
 * */

public interface ConfigConstant {

    String CNAME = "youngf";
    String NAME = "";
    String CONFIG_FILE = "youngf.properties";


    String JDBC_DRIVER = NAME+"jdbc.driver";
    String JDBC_URL = NAME+"jdbc.url";
    String JDBC_USERNAME = NAME+"jdbc.username";
    String JDBC_PASSWORD = NAME+"jdbc.password";
    String APP_BASE_PACKAGE = NAME+"app.base_package";
    String APP_JSP_PATH = NAME+"app.jsp_path";
    String APP_ASSET_PATH = NAME+"app.asset_path";
}
