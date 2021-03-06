package jvm;

import org.testng.annotations.Test;

/**
 * @author zhangsy
 * @date 2017/11/21
 */
public class InitTest {

    public static int a = 1;

    public static void main(String[] args) {

        try {
            Class<?> test = Class.forName("jvm.InitTest");
            System.out.println(test.getClassLoader());


            //根加载器
            Class<?> aClass = Class.forName("java.lang.Runtime");
            System.out.println(aClass.getClassLoader());
            new InitTest();
            System.out.println(a);
            a = a + 1;
            new InitTest();
            System.out.println(a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dir() {
        //工程所在根目录
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }
}
