package pe.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class TestController {

    @RequestMapping("/")
    public ModelAndView defaultHome() {
        return new ModelAndView("login");
    }

//    @RequestMapping("/home")
//    public ModelAndView home() {
//        return new ModelAndView("index");
//    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/user/client")
    public ModelAndView userDashboard() {
        return new ModelAndView("client");
    }

    @RequestMapping("/admin/dashboard")
    public ModelAndView admindashboard() {
        return new ModelAndView("employed");
    }
}
