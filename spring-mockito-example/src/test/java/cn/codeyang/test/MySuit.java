package cn.codeyang.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by meicai on 2016/1/19
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AssertTest.class, TestExecutionOrder.class,
})
public class MySuit {

}
