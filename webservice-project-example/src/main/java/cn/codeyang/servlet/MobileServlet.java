package cn.codeyang.servlet;

import cn.codeyang.service.MobileService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YangZhongYang
 */
public class MobileServlet extends HttpServlet {
    private MobileService mobileService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    public MobileService getMobileService() {
        return mobileService;
    }

    public void setMobileService(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneNum = req.getParameter("phoneNum");
        if (phoneNum != null) {
            phoneNum = phoneNum.trim();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
            mobileService = (MobileService) context.getBean("mobileService");
            String result = mobileService.queryMobile(phoneNum);
            req.setAttribute("result", result);
        }
        req.getRequestDispatcher("/WEB-INF/queryMobile.jsp").forward(req, resp);
    }
}
