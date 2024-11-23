package designPattern.singleton;

/**
 * @author dzq
 * @Date 2024/11/23 14:31
 * @Description
 */
public class SingletonWithDoubleCheck {
    private static volatile SingletonWithDoubleCheck instance;
    SingletonWithDoubleCheck() {}
    public static SingletonWithDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonWithDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonWithDoubleCheck();
                }
            }
        }
        return instance;
    }
}
