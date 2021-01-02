package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.service.ProductFilterService;

@Controller
public class FilterController {

    @Autowired
    private ProductFilterService productFilterService;

    @GetMapping("/productFiltered")
    public String getProductFiltered(Model model, @Param("keyword") String keyword){
        model.addAttribute("productFiltered", productFilterService.findAll(keyword));
        return "product/productFiltered3";
    }
}
