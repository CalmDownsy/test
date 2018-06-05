package rpc;

/**
 * Created by zhangsy on 2018/6/1.
 * Description: 服务提供者实现类
 */
public class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "Hi! " + name;
    }
}
