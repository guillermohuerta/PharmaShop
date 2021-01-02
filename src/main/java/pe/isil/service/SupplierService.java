package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Supplier;
import pe.isil.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public void createOrUpdate(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void delete(Integer id){
        supplierRepository.deleteById(id);
    }

    public Supplier findById(Integer id){
        return supplierRepository.findById(id).orElse(null);
    }

    public List<Supplier> findAll(){
        return supplierRepository.findAll();
    }
}
