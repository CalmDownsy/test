package reflect;

/**
 * @author zhangsy
 * @date 2017/11/28
 */
public class SuperMan extends Man implements Action {

    private int fight;

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
}
