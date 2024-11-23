package designPattern.singleton;

/**
 * @author dzq
 * @Date 2024/11/23 14:57
 * @Description
 */
public class SingletonWithHungry {
    private static SingletonWithHungry instance = new SingletonWithHungry();
    private SingletonWithHungry() {}
    public static SingletonWithHungry getInstance() {
        return instance;
    }
}
