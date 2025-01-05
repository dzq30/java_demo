package designPattern.Proxy.staticProxy;

/**
 * @author dzq
 * @Date 2025/1/5 14:27
 * @Description
 */
public class SendProxy implements SendService {
    private SendService sendService;

    public SendProxy(SendService sendService) {
        this.sendService = sendService;
    }

    @Override
    public void send(String msg) {
        System.out.println("send msg before: " + msg);
        sendService.send(msg);
        System.out.println("send msg after: " + msg);
    }
}

class SendMain {
    public static void main(String[] args) {
        SendProxy sendProxy = new SendProxy(new SendServiceImpl());
        sendProxy.send("hello");
    }
}
