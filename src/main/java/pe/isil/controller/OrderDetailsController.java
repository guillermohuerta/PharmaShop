package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.OrderDetails;
import pe.isil.model.Product;
import pe.isil.service.OrderDetailsService;
import pe.isil.service.OrderService;
import pe.isil.service.ProductService;

@Controller
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/orderDetails")
    public String orderDetailList(Model model){
        model.addAttribute("orderDetails",orderDetailsService.findAll() );
        return "/order/orderDetails";
    }

    @GetMapping("/orderDetails/add")
    public String orderDetailAdd(Model model){
        model.addAttribute("orderDetail", new OrderDetails());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("orders", orderService.findAll());
        return "/order/orderDetail-add";
    }

    @PostMapping("/orderDetails/save")
    public String orderDetailSave(OrderDetails orderDetails){
        orderDetailsService.createOrUpdate(orderDetails);
        return "redirect:/orderDetails";
    }

    @GetMapping("/orderDetails/edit/{id}")
    public String orderDetailEdit(@PathVariable Integer id, Model model){
        model.addAttribute("orderDetail", orderDetailsService.findById(id));
        model.addAttribute("products", productService.findAll());
        model.addAttribute("orders", orderService.findAll());
        return "/order/orderDetail-add";
    }

    @GetMapping("orderDetails/delete/{id}")
    public String orderDetailDelete(@PathVariable Integer id){
        orderDetailsService.delete(id);
        return "redirect:/orderDetails";
    }

}
