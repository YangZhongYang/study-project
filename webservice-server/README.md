# WebService服务端开发
* 开发步骤
    * 创建SEI接口
    * 创建SEI实现类， 需要加@WebService注解
    * 发布服务， 使用Endpoint.publish（服务地址， 实现类实例）
    * 测试服务是否发布成功， 通过阅读wsdl， 确定服务接口， 方法， 参数， 返回值存在说明服务发布成功
        * wsdl地址： 服务地址+?wsdl
        * wsdl的阅读方式， 从下往上阅读， 先找到service标签-->binding-->pointType(包含接口，方法，返回值)-->message