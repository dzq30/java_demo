package designPattern.factory;

/**
 * @author dzq
 * @Date 2024/11/25 20:37
 * @Description
 */
public class ProductA extends AbstractFactory {
    @Override
    public void doSomeThing() {
        System.out.println("ProductA use");
    }
}