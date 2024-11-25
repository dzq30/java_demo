package designPattern.factory;

/**
 * @author dzq
 * @Date 2024/11/25 20:39
 * @Description
 */
public class FactoryBuilder {
    public static AbstractFactory GetProduct(String type) {
        switch (type) {
            case "a":
                return new ProductA();
            case "b":
                return new ProductB();
            case "c":
                return new ProductC();
            default:
                return null;
        }
    }
}
