package util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 */
public final class StringUtil {
    /**
     * 判断字符串是否为空
     * */
    public static boolean isEmpty(String str){
        if(str != null){
            /**
             * 去掉ASCII码值<= ' '(空格)的值
             * */
            //TODO  String中能不能存ASCII码值小于32的不可显字符？
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     * */
    public static boolean isNotEmpty(String str){
        return !StringUtil.isEmpty(str);
    }
}