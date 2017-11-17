package flyweight;

import java.util.HashMap;

/**
 * @author zhangsy
 * @date 2017/11/17
 */
public class FlyWeightFactory {

    private static HashMap<String, FlyWeight> allFlyWeights = new HashMap<String, FlyWeight>();

    public static FlyWeight getFlyWeight(String key) {
        FlyWeight flyWeight = allFlyWeights.get(key);

        if (null == flyWeight) {
            synchronized (allFlyWeights) {
                flyWeight = new FlyWeightImp(key);
                allFlyWeights.put(key, flyWeight);
            }
        }
        System.out.println("size: " + factorySize());
        return flyWeight;
    }

    public static Integer factorySize() {
        return allFlyWeights.size();
    }
}
