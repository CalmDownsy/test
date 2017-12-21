package reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @author zhangsy
 * @date 2017/11/28
 */
public class ReflectTest {

    private Logger logger = LoggerFactory.getLogger(ReflectTest.class);

    @Test(description = "package name")
    public void test1() {
        Man man = new Man();
        logger.info(man.getClass().getPackage().getName());
        //packagename + classname
        logger.info(man.getClass().getName());
        logger.info(man.getClass().getSimpleName());
        logger.info("loader: {}", man.getClass().getClassLoader());
    }


    @Test(description = "class for name")
    public void test2() throws ClassNotFoundException {
        Class c = null;
        //SuperMan.class
        c = Class.forName("reflect.SuperMan");
        logger.info("loader: {}", c.getClassLoader().getClass().getName());
    }

    @Test(description = "new instance")
    public void test3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("reflect.Man");
        Man man = (Man) c.newInstance();
        man.setAge("1");
        man.setName(12);
        logger.info(man.getAge());
    }

    @Test(description = "constructor")
    public void test4() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("reflect.SuperMan");
        Constructor<?>[] constructors = c.getConstructors();
        SuperMan superMan = (SuperMan) constructors[1].newInstance(1, "AS", 5);
        logger.info(superMan.getAge());
    }

    @Test(description = "field")
    public void test5() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> c = Class.forName("reflect.SuperMan");
        SuperMan superMan = (SuperMan) c.newInstance();
        Field[] fields = c.getDeclaredFields();
//        for (Field field : fields) {
//            logger.info(field.getName());
//        }

        Field age = c.getDeclaredField("fight");
        age.setAccessible(true);
        age.set(superMan, 123);
        logger.info("123: {}", superMan.getFight());
    }

    @Test(description = "super interface method")
    public void test6() throws ClassNotFoundException {
        Class<?> c = Class.forName("reflect.SuperMan");
        //super
        Class<?> superclass = c.getSuperclass();
        logger.info("super: {}", superclass.getName());

        //interface
        Class<?>[] interfaces = c.getInterfaces();
        for (Class c1 : interfaces) {
            logger.info("inter: {}", c1.getName());
        }

        //method
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            logger.info(m.getName());
            logger.info("returnType: {}", m.getReturnType());
        }
    }

    @Test(description = "invoke")
    public void test7() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> c = Class.forName("reflect.SuperMan");
        Method fly = c.getDeclaredMethod("fly");
        SuperMan superMan = (SuperMan) c.newInstance();
        fly.invoke(superMan);

        Method walk = c.getDeclaredMethod("walk", int.class);
        walk.invoke(superMan, 2);
    }
}

