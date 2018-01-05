package innerclass;

/**
 * @author zhangsy
 * @date 2017/12/27
 */
public class A {

    public String show(D obj) { //重载
        return ("A and D");
    }

    public String show(A obj) { //被重写
        return ("A and A");
    }

}

class B extends A {
    public String show(B obj) { //重载
        return ("B and B");
    }

    public String show(A obj) { //重写
        return ("B and A");
    }
}

class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();


        B b = new B();

        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b)); // a and a          //aa
        System.out.println("2--" + a1.show(c)); // a and a          //aa
        System.out.println("3--" + a1.show(d)); // a and d          //ad


        System.out.println("4--" + a2.show(b)); // b and b          //ba
        System.out.println("5--" + a2.show(c)); // b and b          //ba

        System.out.println("6--" + a2.show(d)); // a and d          //ad


        System.out.println("7--" + b.show(b)); // b and b           //bb
        System.out.println("8--" + b.show(c)); // b and b           //bb
        System.out.println("9--" + b.show(d)); // a and d           //ad
    }
}

class C extends B {

}

class D extends B {

}
