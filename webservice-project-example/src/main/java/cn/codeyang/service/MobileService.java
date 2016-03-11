package cn.codeyang.service;

import javax.jws.WebService;

/**
 * @author YangZhongYang
 */
@WebService
public interface MobileService {
    public String queryMobile(String phoneNum);
}
