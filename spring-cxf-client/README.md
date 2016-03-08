# 客户端开发步骤
* 开发步骤
    * 根据说明书生成客户端调用代码
    * 在bean中配置
    
            <jaxws:client id="queryWeather" address="http://localhost:8080/spring-cxf-server/ws/weather" serviceClass="cn.codeyang.cxf.helloworld.WeatherInterface" />
    * 调用服务
        
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            WeatherInterface weatherInterface = (WeatherInterface) context.getBean("queryWeather");
            HelloWorld helloWorld = (HelloWorld) context.getBean("sayHello");
            System.out.println(weatherInterface.queryWeather("北京"));
            System.out.println(helloWorld.sayHello("yangzhongyang"));
        