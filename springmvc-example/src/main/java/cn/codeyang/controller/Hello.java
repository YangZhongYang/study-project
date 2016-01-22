package cn.codeyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable Long id){
        System.out.println(id);
        model.addAttribute("name", "delete");

        return "hello";
    }
}
