package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Depot;
import pe.isil.model.Order;
import pe.isil.model.OrderDetails;
import pe.isil.service.OrderService;
import pe.isil.service.UserService;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/orders")
    public String orderList(Model model){
        model.addAttribute("orders", orderService.findAll() );
        return "/order/orders";
    }

    @GetMapping("/orders/add")
    public String orderAdd(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("users", userService.findAll());
        return "/order/order-add";
    }

    @PostMapping("/orders/save")
    public String orderSave(Order order){
        orderService.createOrUpdate(order);
        return "redirect:/orders";
    }

    @GetMapping("/orders/edit/{id}")
    public String orderEdit(@PathVariable Integer id, Model model){
        model.addAttribute("order", orderService.findById(id));
        model.addAttribute("users", userService.findAll());
        return "/order/order-add";
    }

    @GetMapping("orders/delete/{id}")
    public String orderDelete(@PathVariable Integer id){
        orderService.delete(id);
        return "redirect:/orders";
    }

    //showing all the order details that an order has
    @GetMapping("/orders/{id}/orderDetails")
    public String getOrderDetailsListByOrder(@PathVariable Integer id, Model model){

        Order currentOrder = orderService.findById(id);
        if(currentOrder != null){
            List<OrderDetails> orderDetails = currentOrder.getOrderDetails();
            model.addAttribute("orderDetails", orderDetails);
        }
        return "/order/orderDetails";
    }
}
