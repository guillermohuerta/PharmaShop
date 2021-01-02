package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Category;
import pe.isil.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createOrUpdate(Category category){
        categoryRepository.save(category);
    }

    public void delete(Integer id){
        categoryRepository.deleteById(id);
    }

    public Category findById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
