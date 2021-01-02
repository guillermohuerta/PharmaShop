package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Depot;
import pe.isil.model.OrderDetails;
import pe.isil.model.Product;
import pe.isil.service.CategoryService;
import pe.isil.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public String productList(Model model){
        model.addAttribute("products",productService.findAll());
        return "/product/products";
    }

    @GetMapping("/products/add")
    public String productAdd(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "/product/product-add";
    }

    @PostMapping("/products/save")
    public String productSave(Product product){
        productService.createOrUpdate(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String productEdit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "/product/product-add";
    }

    @GetMapping("products/delete/{id}")
    public String productDelete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/products";
    }

    // showing all product deposits that are in the depot
    @GetMapping("/products/{id}/depots")
    public String getDepotsListByProduct(@PathVariable Integer id, Model model){

        Product currentProduct = productService.findById(id);
        if(currentProduct != null){
            List<Depot> depots = currentProduct.getDepots();
            model.addAttribute("depots", depots);
        }

        return "/depot/depots";
    }

    //showing all the order details that an product has
    @GetMapping("/products/{id}/orderDetails")
    public String getOrderDetailsListByProduct(@PathVariable Integer id, Model model){

        Product currentProduct = productService.findById(id);
        if(currentProduct != null){
            List<OrderDetails> orderDetails = currentProduct.getOrderDetails();
            model.addAttribute("orderDetails", orderDetails);
        }

        return "/order/orderDetails";
    }

}
