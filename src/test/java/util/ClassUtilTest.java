package util;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.Assert.*;

public class ClassUtilTest {

    @Test
    public void getClassLoader() {
        System.out.println(ClassUtil.getClassLoader().toString());
    }

    @Test
    public void loadClass() {
        Class<?> cls = ClassUtil.loadClass("helper.ConfigHelper",false) ;
        Method[] methods = cls.getMethods();
        for (Method method:methods) {
            System.out.print(method.getName()+"  ");
        }
    }

    @Test
    public void getClassSet() {
        Set<Class<?>> classSet = ClassUtil.getClassSet("util");
        for (Class<?> cls:classSet) {
            System.out.println(cls.getSimpleName()+" ");
        }
    }
}