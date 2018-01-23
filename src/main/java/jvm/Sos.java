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
        System.out.println(new F().s());
    }

    public void fly() {
        System.out.println(new M().k());
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
