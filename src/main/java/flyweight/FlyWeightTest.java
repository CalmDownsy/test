package flyweight;

/**
 * @author zhangsy
 * @date 2017/11/17
 */
public class FlyWeightTest {

    public static void main(String[] args) {
        FlyWeight bike = FlyWeightFactory.getFlyWeight("bike");
        FlyWeight bike2 = FlyWeightFactory.getFlyWeight("bike");
        FlyWeight car = FlyWeightFactory.getFlyWeight("car");
        bike.action("Two Wheels");
        bike2.action("Three Wheels");
        car.action("Four Wheels");
    }
}
