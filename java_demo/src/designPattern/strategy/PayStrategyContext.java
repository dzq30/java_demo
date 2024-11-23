package designPattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dzq
 * @Date 2024/11/23 15:30
 * @Description
 */
public class PayStrategyContext {
    private static final Map<String, PayStrategy> payStrategyMap = new HashMap<String, PayStrategy>();

    //在实际使用中，如果使用spring框架，可以使用onApplicationEvent方法来扫描所有的PayStrategy实现类bean，并将其注入到payStrategyMap中，这里由于没有spring，所以就先代码写死
    public void initStrategy() {
        AliPay aliPayStrategy = new AliPay();
        WechatPay wechatPayStrategy = new WechatPay();
        payStrategyMap.put(aliPayStrategy.mark(), aliPayStrategy);
        payStrategyMap.put(wechatPayStrategy.mark(), wechatPayStrategy);
    }

    public PayStrategy getStrategy(String mark) {
        if (!payStrategyMap.containsKey(mark)) {
            System.out.println("pay strategy not found");
            return null;
        }
        return payStrategyMap.get(mark);
    }

    public String executePay(String mark) {
        PayStrategy payStrategy = getStrategy(mark);
        if (payStrategy == null) {
            System.out.println("pay strategy not found");
            return "pay strategy not found";
        }
        payStrategy.pay();
        return payStrategy.mark();
    }
}
