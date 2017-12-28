package innerclass;

import org.testng.annotations.Test;

/**
 * @author zhangsy
 * @date 2017/12/28
 */
public class XiaoMing extends Human implements Action {

    @Override
    public void run() {
        System.out.println("ming runs so fast");
    }

    public String say() {
        return "heihei";
    }

    @Test
    public void test() {
        Human human = new XiaoMing();
        human.eat();
        human.sleep();
    }
}
