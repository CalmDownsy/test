package rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by zhangsy on 2018/6/4.
 * Description: 客户端远程代理
 */
public class RPCClient<T> {

    public static <T> T getRemoteProxyObj(final Class<?> serviceInterface, final InetSocketAddress socketAddress) {
        //将本地接口调用转换成JDK动态代理，在动态代理中实现接口的远程调用
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = null;
                ObjectInputStream inputStream = null;
                ObjectOutputStream objectOutputStream = null;
                try {
                    //创建socket客户端，根据地址连接远程服务提供者
                    socket = new Socket();
                    socket.connect(socketAddress);
                    //将远程服务调用所需的接口类、方法名、参数列表传递给服务提供者
                    objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeUTF(serviceInterface.getName());
                    objectOutputStream.writeUTF(method.getName());
                    objectOutputStream.writeObject(method.getParameterTypes());
                    objectOutputStream.writeObject(args);
                    //同步阻塞等待服务器返回应答
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    return inputStream.readObject();
                } finally {
                    if (null != socket) {
                        socket.close();
                    }
                    if (null != objectOutputStream) {
                        objectOutputStream.close();
                    }
                    if (null != inputStream) {
                        inputStream.close();
                    }
                }
            }
        });
    }
}
