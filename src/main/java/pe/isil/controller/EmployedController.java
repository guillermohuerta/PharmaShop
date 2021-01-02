package pe.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployedController {

    @GetMapping({"/employed"})
    public String employedProfile() {
        return "employed";
    }

}
