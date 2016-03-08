package server;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

/**
 * SEI接口
 * @author YangZhongYang
 */
@WebService
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public interface WeatherInterface {
    public String queryWeather(String cityName);
}
