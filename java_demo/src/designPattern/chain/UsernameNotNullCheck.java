package designPattern.chain;

import static designPattern.chain.Consts.*;

/**
 * @author dzq
 * @Date 2024/11/23 15:48
 * @Description
 */
public class UsernameNotNullCheck implements LoginCheckChainInterface{
    @Override
    public boolean execute(LoginParam param) {
        System.out.println("UsernameNotNullCheck fired");
        if (param.getUsername() == null) {
            System.out.println("用户名不能为空");
            return false;
        }
        return true;
    }

    @Override
    public String mark() {
        return UsernameNotNullCheck;
    }

    @Override
    public int order() {
        return 0;
    }
}
