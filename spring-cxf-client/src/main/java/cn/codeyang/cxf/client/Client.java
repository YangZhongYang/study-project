package cn.codeyang.cxf.client;

import cn.codeyang.cxf.helloworld.HelloWorld;
import cn.codeyang.cxf.helloworld.WeatherInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YangZhongYang
 */
public class Client {
    public static void main(String[] args) {
        //初始化Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        WeatherInterface weatherInterface = (WeatherInterface) context.getBean("queryWeather");
        HelloWorld helloWorld = (HelloWorld) context.getBean("sayHello");
        System.out.println(weatherInterface.queryWeather("北京"));
        System.out.println(helloWorld.sayHello("yangzhongyang"));
    }
}
