package innerclass;

import org.testng.annotations.Test;

public class OuterClass {

    private String name;
    private Integer age;
    static int ll  = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void sayHi() {
        System.out.println("Outer hi...");
    }

    public class InnerClass {
        public InnerClass() {
            //this.name 不行 不是内部类的固有属性
            name = "zsy";
            age = 24;
        }

        public void action() {
            sayHi();
            System.out.println("name: " + name + "; age: " + age + ".");
        }

        public OuterClass getOutterClass() {
            return OuterClass.this;
        }
    }

    public InnerClass getInnerClass() {
        final int a = 1;
        class SonOfSon {
            void hihi() {
                name = "123";
                sayHi();
                System.out.println(a + ll);
            }
        }
        //局部内部类只能在该方法体内部调用
        new SonOfSon().hihi();
        return new InnerClass();
    }

    @Test
    public void test() {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.getInnerClass();
        innerClass.getOutterClass().sayHi();
        OuterClass.this.sayHi();
        innerClass.action();

    }

}
