package reflect;

import org.testng.annotations.Test;

/**
 * @author zhangsy
 * @date 2017/11/28
 */
public class Man {

    protected int name = 123;
    private String age;

    public Man() {
        System.out.println("Father");
    }

    public Man(int name, String age) {
        System.out.println("父类构造器被调用了！");
        this.name = name;
        this.age = age;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static void call() {
        System.out.println("father calling!!!");
    }

    @Test
    public void test1() {

    }
}
