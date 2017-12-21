package compare;

import innerclass.LHJ;

import java.util.*;

/**
 * @author zhangsy
 * @date 2017/12/12
 */
public class TestCompare {

    public static void main(String[] args) {
        List<Car> list = new ArrayList<Car>();
        list.add(new Car("BMW", 1000, "R"));
        list.add(new Car("AMW", 1000, "R"));
        list.add(new Car("Koenigsegg", 1210, "Y"));
        list.add(new Car("Bentley", 2000, "R"));
        list.add(new Car("Lamborghini", 1500, "B"));

        Collections.sort(list);
        Iterator<Car> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        Collections.sort(list, new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        System.out.println("---");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        //继承LHJ的匿名类 TestCompare的内部类
        new LHJ() {
            void runagain() {
                super.run();
            }
        }.runagain();
    }
}
