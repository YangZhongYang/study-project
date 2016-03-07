package ws.example1;

import ws.example1.server.MobileCodeWS;
import ws.example1.server.MobileCodeWSSoap;

/**
 * 查询公网手机号归属地
 * @author YangZhongYang
 */
public class Client {
    public static void main(String[] args) {
        MobileCodeWS mobileCodeWS = new MobileCodeWS();
        MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getPort(MobileCodeWSSoap.class);
        String mobileCodeInfo = mobileCodeWSSoap.getMobileCodeInfo("15137685838", null);
        System.out.println(mobileCodeInfo);
    }
}
