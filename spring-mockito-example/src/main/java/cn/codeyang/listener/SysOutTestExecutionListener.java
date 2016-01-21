package cn.codeyang.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * Created by meicai on 2016/1/19
 */
public class SysOutTestExecutionListener implements TestExecutionListener {

    public void beforeTestClass(TestContext testContext) throws Exception {
        System.out.println("In beforeTestClass for class = " + testContext.getTestClass());
    }

    public void prepareTestInstance(TestContext testContext) throws Exception {
        System.out.println("In prepareTestInstance for = " + testContext.getTestInstance());
    }

    public void beforeTestMethod(TestContext testContext) throws Exception {
        System.out.println("In beforeTestMethod for = " + testContext.getTestMethod().getName());
    }

    public void afterTestMethod(TestContext testContext) throws Exception {
        System.out.println("In afterTestMethod for = " + testContext.getTestMethod().getName());
    }

    public void afterTestClass(TestContext testContext) throws Exception {
        ApplicationContext ctx = testContext.getApplicationContext();
        System.out.println("In afterTestClass for class = " + testContext.getTestClass());
    }
}
