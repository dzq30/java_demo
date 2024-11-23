package designPattern.chain;

import java.util.*;

/**
 * @author dzq
 * @Date 2024/11/23 16:27
 * @Description
 */
public class LoginChainContext {
    private static final List<LoginCheckChainInterface> loginChain = new ArrayList<>();

    //这里同策略模式，正常应该在spring中自动捞出所有LoginCheckChainInterface实现类然后注入到map中
    public void initChain() {
        PasswordNotNullCheck passwordNotNullCheck = new PasswordNotNullCheck();
        UsernameNotNullCheck usernameNotNullCheck = new UsernameNotNullCheck();
        PasswordCorrectCheck passwordCorrectCheck = new PasswordCorrectCheck();
        loginChain.add(passwordNotNullCheck);
        loginChain.add(usernameNotNullCheck);
        loginChain.add(passwordCorrectCheck);
        loginChain.sort(Comparator.comparingInt(LoginCheckChainInterface::order));
    }

    public boolean executeWithInterrupted(LoginParam param) {
        for (LoginCheckChainInterface loginCheck : loginChain) {
            System.out.println("now execute " + loginCheck.mark());
            if (!loginCheck.execute(param)) {
                return false;
            }
        }
        return true;
    }

    public boolean executeWithFullExecute(LoginParam param) {
        boolean res = true;
        for (LoginCheckChainInterface loginCheck : loginChain) {
            System.out.println("now execute " + loginCheck.mark());
            if (!loginCheck.execute(param)) {
                res = false;
            }
        }
        return res;
    }
}
