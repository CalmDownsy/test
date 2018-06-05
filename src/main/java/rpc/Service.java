package rpc;

import java.io.IOException;

/**
 * Created by zhangsy on 2018/6/1.
 * Description: 注册中心接口类
 */
public interface Service {

    void stop();

    void start() throws IOException;

    void register(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();
}
