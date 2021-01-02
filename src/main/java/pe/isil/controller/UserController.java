package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Order;
import pe.isil.model.User;
import pe.isil.service.TypeUserService;
import pe.isil.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TypeUserService typeUserService;

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/user/users";
    }

    @GetMapping("/users/add")
    public String userAdd(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("typeUsers", typeUserService.findAll());
        return "/user/user-add";
    }

    @PostMapping("/users/save")
    public String userSave(User user) {
        userService.createOrUpdate(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String userEdit(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("typeUsers", typeUserService.findById(id));
        return "/user/user-add";
    }

    @GetMapping("users/delete/{id}")
    public String userDelete(@PathVariable Integer id){
        userService.delete(id);
        return "redirect:/users";
    }

    //showing all the orders that an user has
    @GetMapping("/users/{id}/orders")
    public String getOrdersListByUser(@PathVariable Integer id, Model model){

        User currentUser = userService.findById(id);
        if(currentUser != null){
            List<Order> orders = currentUser.getOrderList();
            model.addAttribute("orders", orders);
        }
        return "/order/orders";
    }

}
