package designPattern.singleton;

/**
 * @author dzq
 * @Date 2024/11/23 15:03
 * @Description
 */
public class SingletonWithStaticClass {
    private static class SingletonHolder {
        private static final SingletonWithStaticClass INSTANCE = new SingletonWithStaticClass();
    }
    private SingletonWithStaticClass() {}
    public static SingletonWithStaticClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
