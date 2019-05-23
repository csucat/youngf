package util;

import org.junit.Test;
import sun.net.www.protocol.http.HttpURLConnection;

import java.util.Properties;

import static org.junit.Assert.*;

public class PropsUtilTest {

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final Boolean TURN_UP;
    private static int CONNECTION;

    static {
        Properties conf = PropsUtil.loadProps("youngf.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");
        TURN_UP = PropsUtil.getBoolean(conf,"turn_up");
        CONNECTION = PropsUtil.getInt(conf,"jdbc.connection");
    }

    @Test
    public void loadProps() {
        System.out.println(DRIVER+" "+" "+ URL+" "+ USERNAME +" "+PASSWORD);
        if(TURN_UP){
            System.out.println("true"+TURN_UP);
        }else{
            System.out.println("false"+ TURN_UP);
        }
        System.out.println(CONNECTION);
        System.out.println(PropsUtil.class.toString());
    }
}