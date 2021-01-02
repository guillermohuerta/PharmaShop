package pe.isil.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Order;
import pe.isil.model.OrderDetails;
import pe.isil.model.Product;
import pe.isil.repository.OrderDetailsRepository;
import pe.isil.service.OrderService;
import pe.isil.service.ProductFilterService;
import pe.isil.service.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductFilterService productFilterService;

    List<OrderDetails> orderDetailsList = new ArrayList<>();
    Product p = new Product();
    int quantity = 1;
    double subTotal = 0;
    double discount = 0;
    double totalPay = 0;
    
    @GetMapping("/client")
    public String clientProductList(Model model, @Param("keyword") String keyword){
        model.addAttribute("productFiltered", productFilterService.findAll(keyword));
        model.addAttribute("cardsList", orderDetailsList.size());
        return "client";
    }

    @GetMapping("/client/{id}")
    public String productCardIdList(@PathVariable Integer id, Model model){
        Product currentProduct = productService.findById(id);
        addProduct(currentProduct);
        model.addAttribute("orderDetailsList", orderDetailsList.size());
        return "redirect:/client";
    }

    @GetMapping("/cart")
    public String cardList(Model model){
        subTotal = 0;
        discount = 0;
        totalPay = 0;

        model.addAttribute("orderDetailsList", orderDetailsList);

        for (int i = 0; i < orderDetailsList.size(); i++){
            subTotal = subTotal + orderDetailsList.get(i).getSubtotal();
        }

        if (orderDetailsList.size() >= 3){
            discount = subTotal * 0.10;
        }else if (orderDetailsList.size() >= 5){
            discount = subTotal * 0.30;
        }else {
            discount = 0;
        }

        totalPay = subTotal - discount;
        model.addAttribute("subTotal", subTotal);
        model.addAttribute("discount", discount);
        model.addAttribute("totalPay", totalPay);
        return "cart";
    }

    @GetMapping("/cart/save")
    public String paySave(Model model){

        Order order = createOrder();

        for ( OrderDetails orderDetail : orderDetailsList) {
            orderDetail.setOrderId(order.getId());
            orderDetail.setProduct(null);
        }

        orderDetailsRepository.saveAll(orderDetailsList);
        orderDetailsList.clear();

        return "redirect:/client";
    }

    private Order createOrder() {
        Order order = new Order();
        order.setUserId(1);
        order.setTime(LocalDate.now());
        order.setSubTotal(subTotal);
        order.setDiscount(discount);
        order.setTotalPay(totalPay);
        orderService.createOrUpdate(order);
        return order;
    }

    private void addProduct(Product currentProduct) {
        p = currentProduct;
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(null);
        orderDetails.setProductId(p.getId());
        orderDetails.setProduct(p);
        orderDetails.setQuantity(quantity);
        orderDetails.setSubtotal(p.getPrice() * quantity);
        orderDetailsList.add(orderDetails);
    }

}
