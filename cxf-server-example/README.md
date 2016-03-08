# cxf发布端实现
* 开发步骤
    * 导入jar包
    * 创建SEI接口， 加入@WebService注解
    * 创建SEI实现类
    * 发布服务
        * 设置服务接口
        * 设置服务实现类
        * 设置服务地址
        * 发布
* SOAP1.2版本得发布
    * 在SEI接口上添加@BindingType(SOAPBinding.SOAP12HTTP_BINDING)注解即可