package cn.codeyang.test.springformockito;

import cn.codeyang.listener.SysOutTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by meicai on 2016/1/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:cn/codeyang/listener/applicationContext.xml")
@TestExecutionListeners({SysOutTestExecutionListener.class})
public class TestExecutionListenerTest {

    @Test
    public void someTest(){
        System.out.println("executing someTest");
    }

    @Test
    public void someOtherTest(){
        System.out.println("executing someOtherTest");
    }
}
