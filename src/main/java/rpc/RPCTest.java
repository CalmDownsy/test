package rpc;

import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetSocketAddress;

/**
 * Created by zhangsy on 2018/6/4.
 * Description:
 */
public class RPCTest {

    @Test
    public void test() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    ServiceCenter serviceCenter = new ServiceCenter(8088);
                    serviceCenter.register(HelloService.class, HelloServiceImpl.class);
                    serviceCenter.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService helloService = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(helloService.sayHi("Test"));
    }

    @Test
    public void test2() {
        BigDecimal bigDecimal = new BigDecimal(3-2.6);
        System.out.println(bigDecimal);
    }
}



