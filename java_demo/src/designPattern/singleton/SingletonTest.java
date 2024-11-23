package designPattern.singleton;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * @author dzq
 * @Date 2024/11/23 14:52
 * @Description
 */
public class SingletonTest {
    @Test
    public void testSingletonWithDoubleCheck() {
        SingletonWithDoubleCheck instance1 = SingletonWithDoubleCheck.getInstance();
        SingletonWithDoubleCheck instance2 = SingletonWithDoubleCheck.getInstance();

        assertNotNull(instance1);
        assertNotNull(instance2);

        assertSame(instance1, instance2);
    }

    @Test
    public void testSingletonWithHungry() {
        // 调用获取实例的方法
        SingletonWithHungry instance1 = SingletonWithHungry.getInstance();
        SingletonWithHungry instance2 = SingletonWithHungry.getInstance();

        // 断言两个实例是相同的
        assertSame(instance1, instance2);
    }

    @Test
    public void testGetInstance() {
        SingletonWithStaticClass instance1 = SingletonWithStaticClass.getInstance();
        SingletonWithStaticClass instance2 = SingletonWithStaticClass.getInstance();

        // 断言两个实例是相同的
        assertSame(instance1, instance2);
    }
}
