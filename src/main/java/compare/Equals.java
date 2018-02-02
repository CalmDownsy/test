package compare;

import org.testng.annotations.Test;

import java.util.*;

public class Equals {

    private final int a = 2;
    private final Cat c = null;

    //重写equals的基本步骤

    public static void main(String[] args) {

        System.out.println();

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        System.out.println(arrayList.hashCode());
        arrayList.set(0, 2);
        System.out.println(arrayList.hashCode());
    }

    class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Cat)) return false;
            Cat cat = (Cat) o;
            return Objects.equals(name, cat.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    @Test
    public void asd() {
        Cat cat1 = new Cat("123");
        Cat cat2 = new Cat("123");
        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());

        Map<Cat, Integer> h = new HashMap<Cat, Integer>();
        h.put(cat1, 123);
        h.put(cat2, 1234);
        Iterator<Map.Entry<Cat, Integer>> iterator = h.entrySet().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().getKey().name);
//        }
//
//        for (Map.Entry<Cat, Integer> entry : h.entrySet()) {
//            System.out.println(entry.getKey().name);
//        }
        System.out.println(h.get(cat1));

        System.out.println(h.size());

    }

    @Test
    public void ui() {
        //final 不能再赋值

        int[] a = new int[]{1,2};
        System.out.println(a.getClass().getName());
        int[] b = {};

        String[] s = new String[1];
        System.out.println(s.getClass().getName());

        Cat[] c = new Cat[2];
        System.out.println(c.getClass().getName());

    }
}
