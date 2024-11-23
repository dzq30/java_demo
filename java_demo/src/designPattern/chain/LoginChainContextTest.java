package designPattern.chain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginChainContextTest {
    @Test
    public void testSuccessWithInterrupted() {
        // 创建 LoginChainContext 对象并初始化链
        LoginChainContext context = new LoginChainContext();
        context.initChain();

        // 创建测试用的 LoginParam 对象
        LoginParam param = new LoginParam();
        param.setUsername("dzq");
        param.setPassword("123456");

        // 执行链并验证结果
        boolean result = context.executeWithInterrupted(param);
        assertTrue(result);
    }

    @Test
    public void testSuccessWithFullExecute() {
        // 创建 LoginChainContext 对象并初始化链
        LoginChainContext context = new LoginChainContext();
        context.initChain();

        // 创建测试用的 LoginParam 对象
        LoginParam param = new LoginParam();
        param.setUsername("dzq");
        param.setPassword("123456");

        // 执行链并验证结果
        boolean result = context.executeWithFullExecute(param);
        assertTrue(result);
    }

    @Test
    public void testPasswordNullWithInterrupted_Failed() {
        // 创建 LoginChainContext 对象并初始化链
        LoginChainContext context = new LoginChainContext();
        context.initChain();

        // 创建测试用的 LoginParam 对象，密码为空
        LoginParam param = new LoginParam();
        param.setUsername("testUser");

        // 执行链并验证结果为失败
        boolean result = context.executeWithInterrupted(param);
        assertFalse(result);
    }

    @Test
    public void testUsernameNullWithInterrupted_Failed() {
        // 创建 LoginChainContext 对象并初始化链
        LoginChainContext context = new LoginChainContext();
        context.initChain();

        // 创建测试用的 LoginParam 对象，密码为空
        LoginParam param = new LoginParam();
        param.setPassword("123456");

        // 执行链并验证结果为失败
        boolean result = context.executeWithInterrupted(param);
        assertFalse(result);
    }

    @Test
    public void testPasswordNullWithFullExecute_Failed() {
        // 创建 LoginChainContext 对象并初始化链
        LoginChainContext context = new LoginChainContext();
        context.initChain();

        // 创建测试用的 LoginParam 对象，密码为空
        LoginParam param = new LoginParam();
        param.setUsername("testUser");

        // 执行链并验证结果为失败
        boolean result = context.executeWithFullExecute(param);
        assertFalse(result);
    }

    @Test
    public void testUsernameNullWithFullExecute_Failed() {
        // 创建 LoginChainContext 对象并初始化链
        LoginChainContext context = new LoginChainContext();
        context.initChain();

        // 创建测试用的 LoginParam 对象，密码为空
        LoginParam param = new LoginParam();
        param.setPassword("123456");

        // 执行链并验证结果为失败
        boolean result = context.executeWithFullExecute(param);
        assertFalse(result);
    }

    @Test
    public void testUsernameInCorrect_Failed() {
        // 创建 LoginChainContext 对象并初始化链
        LoginChainContext context = new LoginChainContext();
        context.initChain();

        // 创建测试用的 LoginParam 对象，密码为空
        LoginParam param = new LoginParam();
        param.setUsername("wrongUser");
        param.setPassword("123456");

        // 执行链并验证结果为失败
        boolean result = context.executeWithFullExecute(param);
        assertFalse(result);
    }

    @Test
    public void testPasswordInCorrect_Failed() {
        // 创建 LoginChainContext 对象并初始化链
        LoginChainContext context = new LoginChainContext();
        context.initChain();

        // 创建测试用的 LoginParam 对象，密码为空
        LoginParam param = new LoginParam();
        param.setUsername("testUser");
        param.setPassword("wrongPassword");

        // 执行链并验证结果为失败
        boolean result = context.executeWithFullExecute(param);
        assertFalse(result);
    }
}