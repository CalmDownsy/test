package flyweight;


/**
 * @author zhangsy
 * @date 2017/11/17
 */
public class FlyWeightImp implements FlyWeight {

    private String type;

    public FlyWeightImp(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void action(String externalState) {
        System.out.println("external: " + externalState);
        System.out.println("internal: " + this.type);
    }
}
