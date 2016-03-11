package cn.codeyang.service;

import cn.codeyang.mobile.server.MobileCodeWSSoap;

/**
 * @author YangZhongYang
 */
public class MobileServiceImpl implements MobileService {
    private MobileCodeWSSoap mobileClient;

    public String queryMobile(String phoneNum) {
        return mobileClient.getMobileCodeInfo(phoneNum, "");
    }

    public MobileCodeWSSoap getMobileClient() {
        return mobileClient;
    }

    public void setMobileClient(MobileCodeWSSoap mobileClient) {
        this.mobileClient = mobileClient;
    }
}
