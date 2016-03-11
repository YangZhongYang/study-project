package cn.codeyang.client;

import cn.codeyang.service.StudentServiceImpl;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

/**
 * 服务端
 * @author YangZhongYang
 */

public class StudentServer {
    public static void main(String[] args) {
        //JAXRSServerFactoryBean发布REST的服务
        JAXRSServerFactoryBean jaxRSServerFactoryBean = new JAXRSServerFactoryBean();

        //设置服务实现类
        jaxRSServerFactoryBean.setServiceBean(new StudentServiceImpl());
        //设置资源类，如果有多个资源类，可以以“,”隔开。
        jaxRSServerFactoryBean.setResourceClasses(StudentServiceImpl.class);
        //设置服务地址
        jaxRSServerFactoryBean.setAddress("http://127.0.0.1:80/student");
        //发布服务
        jaxRSServerFactoryBean.create();

    }
}
