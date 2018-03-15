package innerclass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Calendar;

/**
 * @author zhangsy
 * @date 2017/12/28
 */
public class XiaoMing extends Human implements Action {

    {
        System.out.println("块");
    }

    public XiaoMing() {
        eat();
    }

    //    @Override
//    @BeforeClass
    public void beforeClass() {
        say();
        super.beforeClass();
//        run();
        eat();
    }

//    @Override
//    public void run() {
//        System.out.println("ming runs so fast");
//    }

    public String say() {
        return "heihei";
    }

    @Override
    public void eat() {
        System.out.println("Ming eating");
    }

    @Test
    public void test() {
//        System.out.println("test begin");
//        XiaoMing xm = new XiaoMing();
////        xm.beforeClass();
////
//        Human human = new XiaoMing();
//        XiaoMing xiaoMing = (XiaoMing) human;
//
//        System.out.println(345678);
//
//        Human hm = new Human();
//        XiaoMing xiaoMing1 = (XiaoMing) hm;
////        human.beforeClass();
        String dbName = "1231";
        String si = "{“DBNames”:[“mydb”,”mydb2”]}";
        String dbInfo = "{\"DBNames\":[\"" + dbName + "\"]}";

        System.out.println(dbInfo);
        System.out.println(si);
    }
}
