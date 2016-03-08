package server;

import javax.jws.WebService;

/**
 * @author YangZhongYang
 */
@WebService
public class HelloWorld {
    public String sayHello(String name){
        return "hello " + name;
    }
}
