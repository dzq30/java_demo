package designPattern.strategy;

/**
 * @author dzq
 * @Date 2024/11/23 15:18
 * @Description
 */
public interface PayStrategy {
    //策略标识
    String mark();

    //支付方法
    void pay();
}
