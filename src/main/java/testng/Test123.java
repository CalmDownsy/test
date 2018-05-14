package testng;

import org.testng.annotations.Test;

public class Test123 {

    @Test
    public void test1() throws InterruptedException {
        System.out.println(1000);
        Thread.sleep(1000);
        System.out.println("11111");
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println(2000);
        Thread.sleep(2000);
        System.out.println("222222");
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println(333);
        Thread.sleep(1000);
        System.out.println("哈哈哈");
    }

    @Test
    public void sda() {
        System.out.println("jw加上");
    }
}
