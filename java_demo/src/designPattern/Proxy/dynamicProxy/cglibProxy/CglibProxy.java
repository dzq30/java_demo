package designPattern.Proxy.dynamicProxy.cglibProxy;

import designPattern.Proxy.dynamicProxy.SendService;
import designPattern.Proxy.dynamicProxy.SendServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author dzq
 * @Date 2025/1/5 15:02
 * @Description
 */
public class CglibProxy {
    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CglibInterceptor());
        return enhancer.create();
    }
}

class cglibMain {
    public static void main(String[] args) {
        SendService proxy = (SendService) CglibProxy.getProxy(CglibSendService.class);
        proxy.send("hello");
    }
}
