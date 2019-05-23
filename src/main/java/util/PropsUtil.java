package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *读取属性文件工具类
 */
public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     * */
    public static Properties loadProps(String filename){
        Properties props = null;
        InputStream is = null;
        try {
            /**
             *得到当前的classpath的绝对路径的URI表示法
             * */
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            if ( is == null) {
                throw new FileNotFoundException(filename+"file is not found.");
            }
            props = new Properties();
            //加载配置文件
            props.load(is);
        } catch (IOException e) {
            LOGGER.error("load Properties file error",e);
        } finally {
            /**
             * finally块中会出现异常，使用正常的异常处理机制try/catch
             * 不要在finally中return(避免逻辑错误)
             * finally用于释放资源，释放资源前先进行判空处理
             * 避免造成java.lang.NullPointerException
             * */
            if (is != null ) {
                try {
                    is.close();
                } catch (IOException e){
                    LOGGER.error("close input stram failture",e);
                }
            }
        }
        return props;
    }
    /**
     * 获取字符型属性,(默认值为空字符串)
     * */
    public static String getString(Properties props,String key){
        return getString(props, key,"");
    }
    /**
     * 获取字符型属性
     * */
    public static String getString(Properties props,String key,String defaultValue){
        String value = defaultValue;
        if(props.containsKey(key)){
            value = props.getProperty(key);
        }
        return value;
    }

    /**
     * 获取数值型属性（指定默认值）
     * */
    public static int getInt(Properties props,String key,int defaultValue){
        int value = defaultValue;
        if(props.containsKey(key)){
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    /**
     * 获取数值型属性（默认值为0）
     * */
    public static int getInt(Properties props,String key){
        return getInt(props, key,0);
    }

    /**
     * 获取Boolean属性（可指定默认值）
     * Properties
     * public synchronized Object setProperty(String key, String value)
     * 第一步所得到的类型全部为String,需进行类型转换
     * */
    public static boolean getBoolean(Properties props,String key,Boolean defaultValue){
        boolean value = defaultValue;
        if(props.containsKey(key)){
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }
    /**
     * 获取Boolean属性（可指定默认值为false）
     * */
    public static boolean getBoolean(Properties props,String key){
        return PropsUtil.getBoolean(props, key,false);
    }


}