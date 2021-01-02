package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Category;
import pe.isil.model.Product;
import pe.isil.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/category/categories";
    }

    @GetMapping("/categories/add")
    public String categoryAdd(Model model) {
        model.addAttribute("category", new Category());
        return "/category/category-add";
    }

    @PostMapping("/categories/save")
    public String categorySave(Category category) {
        categoryService.createOrUpdate(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String categoryEdit(@PathVariable Integer id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "/category/category-add";
    }

    @GetMapping("categories/delete/{id}")
    public String categoryDelete(@PathVariable Integer id){
        categoryService.delete(id);
        return "redirect:/categories";
    }

    // showing all product deposits that are in the category
    @GetMapping("/categories/{id}/products")
    public String getProductsListByCategory(@PathVariable Integer id, Model model){

        Category currentCategory = categoryService.findById(id);
        if(currentCategory != null){
            List<Product> products = currentCategory.getProducts();
            model.addAttribute("products", products);
        }
        return "/product/products";
    }
}
