package designPattern.factory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author dzq
 * @Date 2024/11/25 20:57
 * @Description
 */
public class FactoryTest {
    @Test
    public void testGetProductA() {
        AbstractFactory productA = FactoryBuilder.GetProduct("a");
        assertNotNull(productA);
        // 验证获取到的产品是 ProductA 类型
        assertTrue(productA instanceof ProductA);
    }

    @Test
    public void testGetProductB() {
        AbstractFactory productB = FactoryBuilder.GetProduct("b");
        assertNotNull(productB);
        // 验证获取到的产品是 ProductB 类型
        assertTrue(productB instanceof ProductB);
    }

    @Test
    public void testGetProductC() {
        AbstractFactory productC = FactoryBuilder.GetProduct("c");
        assertNotNull(productC);
        // 验证获取到的产品是 ProductC 类型
        assertTrue(productC instanceof ProductC);
    }

    @Test
    public void testGetProductDefault() {
        AbstractFactory defaultProduct = FactoryBuilder.GetProduct("d");
        assertNull(defaultProduct);
    }
}
