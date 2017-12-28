package datastructure;

import org.testng.annotations.Test;
import sun.security.provider.MD5;

import java.util.Arrays;
import java.util.Random;


/**
 * @author zhangsy
 * @date 2017/12/28
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(arr));

        //异或同一个数两次 还是自身
        for (int q = 0; q < arr.length - 1; q++) {
            for (int a = 0; a < arr.length - q - 1; a++) {
                if (arr[a] > arr[a + 1]) {
                    arr[a] = arr[a] ^ arr[a + 1];
                    arr[a + 1] = arr[a] ^ arr[a + 1];
                    arr[a] = arr[a] ^ arr[a + 1];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test() {
        int a = 2;
        int b = 3;
        //0000 0010
        //0000 0011
        a = a ^ b;
        //0000 0001
        System.out.println(a);
//        a ^ b ^  b
        b = a ^ b;
        System.out.println(b);
//        a ^ b ^ a ^ b ^ b
        a = a ^ b;
        System.out.println(a);

    }
}
