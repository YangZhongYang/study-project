package cn.codeyang.cxf.client;

import cn.codeyang.cxf.weather.WeatherInterface;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @author YangZhongYang
 */
public class Client {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(WeatherInterface.class);
        factoryBean.setAddress("http://127.0.0.1:12345/weather?wsdl");
        WeatherInterface weatherInterface = (WeatherInterface) factoryBean.create();
        String str = weatherInterface.queryWeather("天津");
        System.out.println(str);

    }
}
