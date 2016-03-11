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
 * 2016-03-08T15:53:28.178+08:00
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://server/", name = "HelloWorld")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWorld {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://server/", className = "cn.codeyang.cxf.helloworld.SayHello")
    @WebMethod
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://server/", className = "cn.codeyang.cxf.helloworld.SayHelloResponse")
    public java.lang.String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}