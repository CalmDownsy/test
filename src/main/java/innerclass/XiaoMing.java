package innerclass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author zhangsy
 * @date 2017/12/28
 */
public class XiaoMing extends Human implements Action {

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
        System.out.println("test begin");
        XiaoMing xm = new XiaoMing();
        xm.beforeClass();

        Human human = new XiaoMing();
        XiaoMing xiaoMing = (XiaoMing) human;


        Human hm = new Human();
        XiaoMing xiaoMing1 = (XiaoMing) hm;
        human.beforeClass();
    }
}
