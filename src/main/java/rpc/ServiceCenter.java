package rpc;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangsy on 2018/6/1.
 * Description: 服务中心实现类
 */
public class ServiceCenter implements Service {

    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final HashMap<String, Class> serviceRegister = new HashMap<String, Class>();
    private static boolean isRunning = false;
    private static int port;

    public ServiceCenter(int port) {
        ServiceCenter.port = port;
    }

    public void stop() {
        isRunning = false;
        executor.shutdown();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        System.out.println("server start");
        //监听客户端tcp连接，封装为task，由线程池执行
        try {
            while (true) {
                executor.execute(new ServiceTask(serverSocket.accept()));
            }
        } finally {
            serverSocket.close();
        }
    }

    public void register(Class serviceInterface, Class impl) {
        serviceRegister.put(serviceInterface.getName(), impl);
    }

    public boolean isRunning() {
        return ServiceCenter.isRunning;
    }

    public int getPort() {
        return ServiceCenter.port;
    }

    private static class ServiceTask implements Runnable {

        private Socket client;

        public ServiceTask(Socket client) {
            this.client = client;
        }

        public void run() {
            ObjectInputStream inputStream = null;
            ObjectOutputStream outputStream = null;
            try {

                //将客户端请求码流反序列化成对象，利用反序列化调用服务提供者，获取执行结果
                inputStream = new ObjectInputStream(client.getInputStream());
                String serviceName = inputStream.readUTF();
                String methodName = inputStream.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
                Object[] arguments = (Object[]) inputStream.readObject();
                Class serviceClass = serviceRegister.get(serviceName);
                if (null == serviceClass) {
                    throw new ClassNotFoundException(serviceName + "not found!");
                }
                Method method = serviceClass.getDeclaredMethod(methodName, parameterTypes);
                Object result = method.invoke(serviceClass.newInstance(), arguments);

                //将执行结果反序列化，通过socket发送给客户端
                outputStream = new ObjectOutputStream(client.getOutputStream());
                outputStream.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != outputStream) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (null != inputStream) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (null != client) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
