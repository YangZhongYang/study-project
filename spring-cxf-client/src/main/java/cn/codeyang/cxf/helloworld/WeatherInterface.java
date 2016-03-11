package cn.codeyang.cxf.helloworld;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2016-03-08T15:59:51.826+08:00
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://server/", name = "WeatherInterface")
@XmlSeeAlso({ObjectFactory.class})
public interface WeatherInterface {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "queryWeather", targetNamespace = "http://server/", className = "cn.codeyang.cxf.helloworld.QueryWeather")
    @WebMethod
    @ResponseWrapper(localName = "queryWeatherResponse", targetNamespace = "http://server/", className = "cn.codeyang.cxf.helloworld.QueryWeatherResponse")
    public java.lang.String queryWeather(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}