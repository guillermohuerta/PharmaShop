package pe.isil.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.isil.model.Supplier;
import pe.isil.repository.SupplierRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class SupplierLoader implements CommandLineRunner {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Supplier> supplierList = new ArrayList<>();
        supplierList.add(new Supplier(null, "LABORATORIO MEDIFARMA S.A.", "+51 879895684", "medifarma@gmail.com", "Jirón Antonio De Elizalde, 825, 839",null));
        supplierList.add(new Supplier(null, "NIPRO MEDICAL PERU S.A.", "+51 321654987", "nipro@gmail.com", "Jirón Mariano De Los Santos, 115, Of. 503",null));
        supplierList.add(new Supplier(null, "LABORATORIO BAGO SA..", "+51 654369856", "bago@gmail.com", "Camino Real, 159",null));
        supplierList.add(new Supplier(null, "LABORATORIO LANSIER.", "+51 456325698", "lansier@gmail.com", "Avenida Miguel Grau, 785",null));
        supplierList.add(new Supplier(null, "FARMINDUSTRIA S.A.", "+51 123657485", "farmindustria@gmail.com", "Jr. Diana Mz B Lote 6 Urb. Santa Modesta",null));

        supplierRepository.saveAll(supplierList);
    }
}
