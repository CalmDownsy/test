package datastructure;

import org.testng.annotations.Test;

/**
 * @author zhangsy
 * @date 2017/12/25
 */
public class ArraysTest {

    @Test
    public void test1() {

        //无法获取实际元素个数
        int[] arr = new int[2];
        arr[0] = 1;
        System.out.println(arr[1]);
    }
}
