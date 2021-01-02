package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Product;
import pe.isil.repository.ProductFilterRepository;

import java.util.List;

@Service
public class ProductFilterService {

    @Autowired
    private ProductFilterRepository productFilterRepository;

    public List<Product> findAll(String keyword){
        if (keyword != null){
            return productFilterRepository.findAll(keyword);
        }
        return productFilterRepository.findAll();
    }
}
