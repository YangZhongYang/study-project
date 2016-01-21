package cn.codeyang.test.springformockito;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by meicai on 2016/1/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = MyConfig.class, initializers = EnvironmentTest.MockPropertyInitializer.class)
@ContextConfiguration(classes = MyConfig.class, initializers = MockPropertyInitializer.class)
public class EnvironmentTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void environment(){
        assertEquals("I'm the king", context.getBean("message"));
    }

    public static class MockPropertyInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

        public void initialize(ConfigurableApplicationContext applicationContext) {
            MockEnvironment mock = new MockEnvironment();
            mock.setProperty("message", "I'm a mockstar");
            applicationContext.setEnvironment(mock);
        }
    }
}
