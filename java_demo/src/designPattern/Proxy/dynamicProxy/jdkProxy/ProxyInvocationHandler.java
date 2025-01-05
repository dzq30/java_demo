package designPattern.Proxy.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dzq
 * @Date 2025/1/5 14:34
 * @Description
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private final Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk before send msg");
        Object result = method.invoke(target, args);
        System.out.println("jdk after send msg");
        return result;
    }
}
