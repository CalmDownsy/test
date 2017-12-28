package innerclass;

/**
 * @author zhangsy
 * @date 2017/12/28
 */
public abstract class Human {

    private String name;
    private static final int EYES = 2;

    //这是一个方法体为空的普通方法，并非抽象方法，抽象类中可以没有抽象方法
    void sleep() {}

    //这是一个抽象方法，那么类必须注明为抽象类，且派生类必须重写抽象方法
    public abstract void run();

    public void eat() {
        System.out.println("everyone needs food");
    }
}
