package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码与解码
 * */


public final class CodeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeUtil.class);

    /**
     * 将URL编码
     * */
    public static String encodeURL(String source){
        String target;
        try {
            target = URLEncoder.encode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode failure",e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将URL解码
     * */
    public static String decodeURL(String source){
        String target;
        try {
            target = URLDecoder.decode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("decode failure",e);
            throw new RuntimeException(e);
        }
        return target;
    }

}
