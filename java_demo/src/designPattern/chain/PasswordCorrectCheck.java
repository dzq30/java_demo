package designPattern.chain;

import static designPattern.chain.Consts.*;

/**
 * @author dzq
 * @Date 2024/11/23 16:15
 * @Description
 */
public class PasswordCorrectCheck implements LoginCheckChainInterface {

    @Override
    public String mark() {
        return PasswordCorrectCheckMark;
    }

    @Override
    public boolean execute(LoginParam params) {
        System.out.println("PasswordCorrectCheck fired");
        if (params.getUsername() != Username) {
            System.out.println("username is not correct");
            return false;
        } else if (params.getPassword() != Password) {
            System.out.println("password is not correct");
            return false;
        }
        return true;
    }

    @Override
    public int order() {
        return 3;
    }
}
