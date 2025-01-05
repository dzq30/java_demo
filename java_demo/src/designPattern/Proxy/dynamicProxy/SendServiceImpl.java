package designPattern.Proxy.dynamicProxy;

/**
 * @author dzq
 * @Date 2025/1/5 14:33
 * @Description
 */
public class SendServiceImpl implements SendService {
    @Override
    public void send(String msg) {
        System.out.println("send msg: " + msg);
    }
}
