package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.service.ProductService;

@Controller
public class ClientController {

    @Autowired
    private ProductService productService;

//    @GetMapping("/client")
//    public String clientProductList(Model model){
//        model.addAttribute("products",productService.findAll() );
//        return "client";
//    }
}
