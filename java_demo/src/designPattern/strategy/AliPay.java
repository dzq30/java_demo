package designPattern.strategy;

/**
 * @author dzq
 * @Date 2024/11/23 15:21
 * @Description
 */
public class AliPay implements PayStrategy{
    @Override
    public String mark() {
        return "alipay";
    }

    @Override
    public void pay() {
        System.out.println("this is alipay");
    }
}
