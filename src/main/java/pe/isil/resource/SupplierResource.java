package pe.isil.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.model.Product;
import pe.isil.model.Supplier;
import pe.isil.service.ProductService;
import pe.isil.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierResource {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProductService productService;

    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> getSuppliers() {

        List<Supplier> suppliers = supplierService.findAll();

        if (suppliers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Integer id) {
        Supplier supplier = supplierService.findById(id);

        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @PostMapping("/suppliers")
    public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier) {
        supplierService.createOrUpdate(supplier);
        return new ResponseEntity<>(supplier, HttpStatus.CREATED);
    }

    @PutMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Integer id,
                                                   @RequestBody Supplier supplier) {

        Supplier currentSupplier = supplierService.findById(id);
        if (currentSupplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        supplier.setId(id);
        supplierService.createOrUpdate(supplier);

        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @DeleteMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable Integer id) {

        Supplier currentSupplier = supplierService.findById(id);
        if (currentSupplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        supplierService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
