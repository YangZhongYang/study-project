package ws.example4;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author YangZhongYang
 */
public class Client {
    public static void main(String[] args) {
        try {
            //创建服务地址
            URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            //设置数据格式
            connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            String soapXML = getXML("15137685838");
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(soapXML.getBytes());
            int responseCode = connection.getResponseCode();
            InputStream inputStream = connection.getInputStream();

            if (responseCode == 200){
                byte[] bys = new byte[1024];
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                reader.readLine();
                int len = 0;
                while ((len = inputStream.read(bys)) != -1){
                    System.out.println(new String(bys, 0 ,len));
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getXML(String phoneID){
        return "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">\n" +
                "      <mobileCode>"+phoneID+"</mobileCode>\n" +
                "      <userID></userID>\n" +
                "    </getMobileCodeInfo>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
    }
}
