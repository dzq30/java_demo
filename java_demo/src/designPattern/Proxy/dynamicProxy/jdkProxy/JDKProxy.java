package designPattern.Proxy.dynamicProxy.jdkProxy;

import designPattern.Proxy.dynamicProxy.SendService;
import designPattern.Proxy.dynamicProxy.SendServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author dzq
 * @Date 2025/1/5 14:37
 * @Description
 */
public class JDKProxy {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ProxyInvocationHandler(target)
        );
    }
}

class JdkProxyMain {
    public static void main(String[] args) {
        SendService proxy = (SendService) JDKProxy.getProxy(new SendServiceImpl());
        proxy.send("hello");
    }
}
