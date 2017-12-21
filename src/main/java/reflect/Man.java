package reflect;

/**
 * @author zhangsy
 * @date 2017/11/28
 */
public class Man {

    private int name;
    private String age;

    public Man() {}

    public Man(int name, String age) {
        this.name = name;
        this.age = age;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
