
import helper.BeanHelper;
import helper.ClassHelper;
import helper.ControllerHelper;
import helper.IocHelper;
import util.ClassUtil;

public final class HelperLoader {
    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls: classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
