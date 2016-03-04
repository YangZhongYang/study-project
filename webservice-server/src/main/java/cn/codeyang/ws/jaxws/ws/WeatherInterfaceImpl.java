package cn.codeyang.ws.jaxws.ws;

import javax.jws.WebService;

/**
 * @author YangZhongYang
 */
@WebService
public class WeatherInterfaceImpl implements WeatherInterface {
    public String queryWeather(String cityName) {
        System.out.println("from client ... " + cityName);
        String weather = "晴";
        return weather;
    }
}
