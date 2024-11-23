package designPattern.chain;

import static designPattern.chain.Consts.*;

/**
 * @author dzq
 * @Date 2024/11/23 16:13
 * @Description
 */
public class PasswordNotNullCheck implements LoginCheckChainInterface {
    @Override
    public String mark() {
        return PasswordNotNullCheck;
    }

    @Override
    public boolean execute(LoginParam params) {
        System.out.println("PasswordNotNullCheck fired");
        if (params.getPassword() == null) {
            System.out.println("密码不能为空");
            return false;
        }
        return true;
    }

    @Override
    public int order() {
        return 1;
    }
}
