package cn.codeyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by meicai on 2016/1/21
 */
@Controller
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
}
