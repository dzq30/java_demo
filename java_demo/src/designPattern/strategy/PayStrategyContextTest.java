package designPattern.strategy;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PayStrategyContextTest {
    @Test
    public void testGetStrategy() {
        PayStrategyContext context = new PayStrategyContext();
        context.initStrategy();

        PayStrategy aliPayStrategy = context.getStrategy("alipay");
        assertNotNull(aliPayStrategy);

        PayStrategy wechatStrategy = context.getStrategy("wechat");
        assertNotNull(wechatStrategy);

        PayStrategy notExistStrategy = context.getStrategy("notExist");
        assertNull(notExistStrategy);
    }

    @Test
    public void testExecutePay() {
        PayStrategyContext context = new PayStrategyContext();
        context.initStrategy();

        String result = context.executePay("alipay");
        assertEquals("alipay", result);

        String wechatResult = context.executePay("wechat");
        assertEquals("wechat", wechatResult);

        result = context.executePay("notExist");
        assertEquals("pay strategy not found", result);
    }
}