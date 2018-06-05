package datastructure;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangsy on 2018/5/30.
 */
public class FindRepeat {

    @Test
    public void findRepeat() {
        String str = "aoidfgfuuaadw";
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char s : str.toCharArray()) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
