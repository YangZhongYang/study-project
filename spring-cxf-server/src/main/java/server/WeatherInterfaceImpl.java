package server;

/**
 * @author YangZhongYang
 */
public class WeatherInterfaceImpl implements WeatherInterface {
    public String queryWeather(String cityName) {
        System.out.println("from client...." + cityName);
        if ("北京".equals(cityName)){
            return "雾霾天气";
        }else{
            return "晴空万里";
        }
    }
}
