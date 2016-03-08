# cxf客户端开发
* 开发步骤
    * 生成客户端代码(wsdl2java -p cn.codeyang.cxf.weather -d . http://127.0.0.1:12345/weather?wsdl)
    * 使用JaxWsProxyFactoryBean调用服务端
        * 设置服务接口(setServiceClass)
        * 设置服务地址(setAddress)
        * 获取服务接口实例(create)
        * 调用查询方法
* 添加拦截器
    * JaxWsProxyFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
    * JaxWsProxyFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());