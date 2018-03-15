package datastructure;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @author zhangsy
 * @date 2017/12/25
 */
public class ArraysTest {

    @Test
    public void test1() {

        //无法获取实际元素个数
        int[] arr = new int[]{1,2,3,4};
        arr[0] = 1;
        System.out.println(arr[1]);

        List<Integer> l = new ArrayList<Integer>();
        System.out.println(10 >> 1);

        //0101 4
        //0010 2
        String[] arr3 = {"1","2"};
        //基本数据类型不能泛型化，将数组当成了一个对象
        System.out.println(Arrays.asList(arr).size());  // 1
        System.out.println(Arrays.asList(arr3).size());

        LinkedList<String> ll = new LinkedList<String>();
    }
}
