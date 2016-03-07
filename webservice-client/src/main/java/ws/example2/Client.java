package ws.example2;


import ws.example2.server.ArrayOfString;
import ws.example2.server.WeatherWS;
import ws.example2.server.WeatherWSSoap;

import java.util.List;

/**
 * @author YangZhongYang
 */
public class Client {
    public static void main(String[] args) {
        WeatherWS weatherWS = new WeatherWS();
        WeatherWSSoap weatherWSSoap = weatherWS.getPort(WeatherWSSoap.class);
        ArrayOfString arrayOfString = weatherWSSoap.getWeather("北京", "");
        List<String> strList = arrayOfString.getString();
        for (String s : strList) {
            System.out.println(s);
        }

    }
}
