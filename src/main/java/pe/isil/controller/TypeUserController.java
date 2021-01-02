package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.TypeUser;
import pe.isil.model.User;
import pe.isil.service.TypeUserService;

import java.util.List;

@Controller
public class TypeUserController {

    @Autowired
    private TypeUserService typeUserService;

    @GetMapping("/typeUsers")
    public String typeUserList(Model model) {
        model.addAttribute("typeUsers", typeUserService.findAll());
        return "/user/typeUsers";
    }

    @GetMapping("/typeUsers/add")
    public String typeUserAdd(Model model) {
        model.addAttribute("typeUser", new TypeUser());
        return "/user/typeUser-add";
    }

    @PostMapping("/typeUsers/save")
    public String typeUserSave(TypeUser typeUser) {
        typeUserService.createOrUpdate(typeUser);
        return "redirect:/typeUsers";
    }

    @GetMapping("/typeUsers/edit/{id}")
    public String typeUserEdit(@PathVariable Integer id, Model model){
        model.addAttribute("typeUser", typeUserService.findById(id));
        return "/user/typeUser-add";
    }

    @GetMapping("typeUsers/delete/{id}")
    public String typeUserDelete(@PathVariable Integer id){
        typeUserService.delete(id);
        return "redirect:/typeUsers";
    }

    // showing all user deposits that are in the TypeUser
    @GetMapping("/typeUsers/{id}/users")
    public String getUsersListByTypeUser(@PathVariable Integer id, Model model){

        TypeUser currentTypeUser = typeUserService.findById(id);
        if(currentTypeUser != null){
            List<User> users = currentTypeUser.getUsers();
            model.addAttribute("users", users);
        }

        return "/user/users";
    }
}
