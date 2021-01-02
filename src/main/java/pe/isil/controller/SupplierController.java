package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Depot;
import pe.isil.model.Supplier;
import pe.isil.service.SupplierService;

import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    public String supplierList(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "/supplier/suppliers";
    }

    @GetMapping("/suppliers/add")
    public String supplierAdd(Model model){
        model.addAttribute("supplier", new Supplier());
        return "/supplier/supplier-add";
    }

    @PostMapping("/suppliers/save")
    public String supplierSave(Supplier supplier) {
        supplierService.createOrUpdate(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/edit/{id}")
    public String supplierEdit(@PathVariable Integer id, Model model){
        model.addAttribute("supplier", supplierService.findById(id));
        return "/supplier/supplier-add";
    }

    @GetMapping("suppliers/delete/{id}")
    public String supplierDelete(@PathVariable Integer id){
        supplierService.delete(id);
        return "redirect:/suppliers";
    }

    //showing all supplier deposits that are in the depot
    @GetMapping("/suppliers/{id}/depots")
    public String getDepotsListBySupplier(@PathVariable Integer id, Model model){

        Supplier currentSupplier = supplierService.findById(id);
        if(currentSupplier != null){
            List<Depot> depots = currentSupplier.getDepots();
            model.addAttribute("depots", depots);
        }

        return "/depot/depots";
    }

}
