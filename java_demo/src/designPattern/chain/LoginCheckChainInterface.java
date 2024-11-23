package designPattern.chain;

/**
 * @author dzq
 * @Date 2024/11/23 15:44
 * @Description
 */
public interface LoginCheckChainInterface {
    //责任链节点标识
    String mark();

    //具体执行方法
    boolean execute(LoginParam params);

    //优先级
    int order();
}
