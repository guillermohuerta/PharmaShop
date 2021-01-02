package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Depot;
import pe.isil.service.DepotService;
import pe.isil.service.ProductService;
import pe.isil.service.SupplierService;

@Controller
public class DepotController {

    @Autowired
    private DepotService depotService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProductService productService;


    @GetMapping("/depots")
    public String depotList(Model model){
        model.addAttribute("depots",depotService.findAll() );
        return "/depot/depots";
    }

    @GetMapping("/depots/add")
    public String depotAdd(Model model){
        model.addAttribute("depot", new Depot());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        return "/depot/depot-add";
    }

    @PostMapping("/depots/save")
    public String depotSave(Depot depot){
        depotService.createOrUpdate(depot);
        return "redirect:/depots";
    }

    @GetMapping("/depots/edit/{id}")
    public String depotEdit(@PathVariable Integer id, Model model){
        model.addAttribute("depot", depotService.findById(id));
        model.addAttribute("products", productService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        return "/depot/depot-add";
    }

    @GetMapping("depots/delete/{id}")
    public String depotDelete(@PathVariable Integer id){
        depotService.delete(id);
        return "redirect:/depots";
    }
}
