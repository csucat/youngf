package helper;

import annotation.Action;
import bean.Handler;
import bean.Request;
import util.ArrayUtil;
import util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ControllerHelper {
    /**
     * 用于存放请求与处理器的映射关系(Action_Map)
     * */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getClassSet();
        if(CollectionUtil.isNotEmpty(controllerClassSet)){
            //遍历这些Controller类
            for (Class<?> controllerClass:controllerClassSet) {
                //获取Controller类中定义的方法
                Method[] methods = controllerClass.getMethods();
                if(ArrayUtil.isNotEmpty(methods)){
                    //遍历Controller类中的方法
                    for (Method method : methods) {
                        //判断当前方法是否有Action注解
                        if(method.isAnnotationPresent(Action.class)){
                            //从action注解中获取Url的映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证url映射规则
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] array = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(array) && array.length == 2){
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod,requestPath);
                                    Handler handler = new Handler(controllerClass,method);
                                    //初始化Action Map
                                    ACTION_MAP.put(request,handler);
                                }
                            }

                        }
                    }
                }
            }
        }

    }

    /**
     * 获取Handler
     * */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }
}
