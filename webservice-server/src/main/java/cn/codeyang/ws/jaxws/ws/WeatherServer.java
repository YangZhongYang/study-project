package cn.codeyang.ws.jaxws.ws;

import javax.xml.ws.Endpoint;

/**
 * @author YangZhongYang
 */
public class WeatherServer {
    public static void main(String[] args) {
        //通过Endpoint发布服务
        Endpoint.publish("http://127.0.0.1:12345/weather", new WeatherInterfaceImpl());
    }
}
