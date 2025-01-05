package designPattern.Proxy.staticProxy;

/**
 * @author dzq
 * @Date 2025/1/5 14:26
 * @Description
 */
public class SendServiceImpl implements SendService {
    @Override
    public void send(String msg)  {
        System.out.println("send msg:"+msg);
    }
}
