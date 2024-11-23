package designPattern.strategy;

/**
 * @author dzq
 * @Date 2024/11/23 15:20
 * @Description
 */
public class WechatPay implements PayStrategy{
    @Override
    public void pay() {
        System.out.println("this is wechat pay");
    }

    @Override
    public String mark() {
        return "wechat";
    }
}
