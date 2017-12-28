package reflect;

import org.testng.annotations.Test;

/**
 * @author zhangsy
 * @date 2017/11/28
 */
public class SuperMan extends Man implements Action {

    private int fight;
    private int name = 1234;

    public SuperMan() {}

    public SuperMan(int name, String age, int fight) {
        super(name, age);
        this.fight = fight;
    }

    public void fly() {
        System.out.println("super man flying!!");
    }

    public void walk(int m) {
        System.out.println("super man walk " + m + "km!");
    }

    public int getFight() {
        return fight;
    }

    public void setFight(int fight) {
        this.fight = fight;
    }

    public static void call() {
        System.out.println("son calling!!!");
    }

    @Test
    public void test1() {
        SuperMan man = new SuperMan();
        System.out.println(man.getName());
        System.out.println(man.name);

        Man man1 = new SuperMan();
        System.out.println(man1.name);
//        Man.call();
    }
}
