package designPattern.Proxy.dynamicProxy.cglibProxy;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author dzq
 * @Date 2025/1/5 14:49
 * @Description
 */
public class CglibInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before method invoke");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib after method invoke");
        return result;
    }
}
