package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Product;
import pe.isil.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createOrUpdate(Product product){
        productRepository.save(product);
    }

    public void delete(Integer id){
        productRepository.deleteById(id);
    }

    public Product findById(Integer id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findAll( ){
        return productRepository.findAll();
    }

}
