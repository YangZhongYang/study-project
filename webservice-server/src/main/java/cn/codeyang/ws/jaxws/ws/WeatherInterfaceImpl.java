package cn.codeyang.ws.jaxws.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

/**
 * @author YangZhongYang
 */
@WebService(
        targetNamespace = "http://service.cn.codeyang",
        name = "queryWeatherSoap",
        portName = "queryWeatherSoap",
        serviceName = "weatherWS"

)
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class WeatherInterfaceImpl implements WeatherInterface {

    @WebMethod(operationName = "getWeather", exclude = false)
    public @WebResult(name = "result")String queryWeather(@WebParam(name = "cityName")String cityName) {
        System.out.println("from client ... " + cityName);
        String weather = "晴";
        return weather;
    }
}
