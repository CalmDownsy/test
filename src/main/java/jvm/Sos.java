package jvm;

import org.testng.annotations.Test;

public class Sos implements InterfaceA, InterfaceB {

    @Test
    public void test() {
        System.out.println(InterfaceA.name);
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }

    public void run() {

    }

    public void fly() {

    }

    class F extends Ff {
        @Override
        public int s() {
            return super.s() + 1;
        }
    }

    class M extends Mm {
        @Override
        public int k() {
            return super.k() - 2;
        }
    }



}
