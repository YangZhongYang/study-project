# WebService客户端开发
* 开发步骤
    * 第一步：wsimport命令生成客户端代码
    * 第二步：根据使用说明书，使用客户端代码调用服务端, 使用命令wsimport -s . 服务地址？wsdl
        * 第一步：创建服务视图， 视图是从说明书中service标签的name属性获取
        * 第二步：获取服务实现类，实现类从portType的name属性中获取
        * 第三步：获取查询方法，从portType的operation标签获取
    
* WebService应用场景
    * 软件集成和复用
    
* 适用场景
    * 发布一个服务（对内/对外），不考虑客户端类型，不考虑性能，建议使用webservice
    * 服务端已经确定使用webservice，客户端不能选择，必须使用webservice
* 不适用场景
    * 考虑性能不建议使用webservice
    * 同构程序下不建议使用webservice
    
* WSDL
    * wsdl即web服务描述语言， webservice服务端使用说明书， 说明服务端接口，方法，参数和返回值， 随服务发布，不需要编写
    * 结构说明
        * <service> 服务视图， webservice服务结点， 他包括了服务端点
        * <binding> 为每个服务端点定义消息格式和协议细节
        * <portType> 服务端点，描述webservice可被执行的操作方法，以及相关的消息，通过binding指向portType
        * <message>定义一个操作（方法）的数据参数（可有多个参数）
        * <types> 定义webservice使用的全部数据类型
* 调用方式
    * 生成客户端调用方式
    * service编程方式
        * 创建WSDL url地址-->URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
        * 创建服务名称-->QName qname = new QName("http://WebXml.com.cn/", "MobileCodeWS");
        * 创建服务视图-->Service.create(url, qname);
        * 获取服务实现类-->service.getPort(MobileCodeWSSoap.class);
        * 调用查询方法-->mobileCodeWSSoap.getMobileCodeInfo("15137685838", "");
    * HttpURLConnection调用方式
        * 创建服务地址-->URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx"); *非WSDL地址*
        * 打开一个通向服务地址的链接
        * 设置参数
        * 组织SOAP数据
        * 接收服务端响应
    * ajax调用方式