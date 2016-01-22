package cn.codeyang.controller;

import cn.codeyang.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by meicai on 2016/1/21
 */
@Controller
@RequestMapping("/blog")
public class Hello {

    @RequestMapping("/hello1.do")
    public ModelAndView query(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping("/hello2.do")
    public String query2(Model model){
        model.addAttribute("name", "zhangsan");

        return "hello";
    }


    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable Long id){
        System.out.println(id);
        model.addAttribute("name", "delete");

        return "hello";
    }

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    @ResponseBody
    public  User ajax(Model model){
        System.out.println("123");
        User user = new User();
        user.setUserId(1L);
        user.setUsername("zhangsan");

        return user;
    }
}
