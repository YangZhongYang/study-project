package ws.example3;

import ws.example1.server.MobileCodeWSSoap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Service编程实现服务端调用
 * @author YangZhongYang
 */
public class ServerClient {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
            QName qname = new QName("http://WebXml.com.cn/", "MobileCodeWS");
            //1 创建服务视图,
            Service service = Service.create(url, qname);
            //2 获取服务实现类
            MobileCodeWSSoap mobileCodeWSSoap = service.getPort(MobileCodeWSSoap.class);
            //3 调用查询方法
            String mobileCodeInfo = mobileCodeWSSoap.getMobileCodeInfo("15137685838", "");
            System.out.println(mobileCodeInfo);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
