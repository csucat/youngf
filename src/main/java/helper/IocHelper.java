package helper;

import annotation.Inject;
import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;
import util.CollectionUtil;
import util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class IocHelper {

    /**
     * IoC容器初始化
     *
     * BeanMap 中的实例全为单例
     * */
    static{
        //获取所有Bean类与Bean实例之间的映射关系(BeanMap)
        Map<Class<?>,Object> beanMap = new HashMap<Class<?>, Object>();
        if(CollectionUtil.isNotEmpty(beanMap)){
            //遍历BeanMap
            for (Map.Entry<Class<?>,Object>beanEntry:beanMap.entrySet()) {
                //从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean类定义的所有成员变量(Bean field)
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(beanFields)){
                    //遍历bean fields
                    for (Field beanField: beanFields) {
                        if(beanField.isAnnotationPresent(Inject.class)){
                            //在Bean Map中获取 Bean Field 对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance != null){
                                //通过反射初始化BeanField 的值
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }


}
