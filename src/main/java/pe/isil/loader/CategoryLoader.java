package pe.isil.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.isil.model.Category;
import pe.isil.model.Product;
import pe.isil.repository.CategoryRepository;
import pe.isil.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryLoader implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(null,"Analgésicos",null));
        categoryList.add(new Category(null,"Antiácidos y antiulcerosos",null));
        categoryList.add(new Category(null,"Antialérgicos",null));
        categoryList.add(new Category(null,"Antidiarreicos y laxantes",null));

        categoryRepository.saveAll(categoryList);


        List<Product> productList = new ArrayList<>();
        productList.add(new Product(null, "Ibuprofeno", 50.00, "El Ibuprofeno es un derivado del ácido propiónico que inhibe la síntesis de prostaglandinas",
                "https://ld-wp73.template-help.com/woocommerce/prod_27637/v1/wp-content/uploads/2019/12/DABUR-Maharasnadi-Kwath-2.png", 1, null, null,null));
        productList.add(new Product(null, "Almax Forte 24 Sobres", 20.00, "Almax Forte es un tratamiento sintomático de la acidez de estómago que actúa de forma eficaz y rápida.",
                "https://ld-wp73.template-help.com/woocommerce/prod_27637/v1/wp-content/uploads/2019/12/Enzyme-new-age-3.png", 2, null, null,null));
        productList.add(new Product(null, "Gaviscon 24 Comprimidos Masticables", 20.00, "Gaviscon 24 Comprimidos Masticables Fresa son ideales para aliviar las molestias producidas por la acidez y el reflujo gástrico.",
                "https://ld-wp73.template-help.com/woocommerce/prod_27637/v1/wp-content/uploads/2019/12/Equate-Cold-Multi-Symptom-DaytimeNighttime-2.png", 2, null, null,null));
        productList.add(new Product(null, "Almax Forte 24 Sobres", 15.00, "Almax Forte es un tratamiento sintomático de la acidez de estómago que actúa de forma eficaz y rápida.",
                "https://ld-wp73.template-help.com/woocommerce/prod_27637/v1/wp-content/uploads/2019/12/Benadryl-Child-Plus-Conge-1.png", 2, null, null,null));
        productList.add(new Product(null, "Dulcolaxo", 25.00, "Comprimidos con propiedades laxantes para el alivio del estreñimiento, tanto en adultos como en niños.",
                "https://ld-wp73.template-help.com/woocommerce/prod_27637/v1/wp-content/uploads/2019/12/Dr.-Scholls-CORN-REMOVER-1.png", 4, null, null,null));
        productList.add(new Product(null, "Fave de Fuca 40 Comprimidos", 10.00, "Asociación de extractos vegetales laxantes para favorecer la actividad intestinal en caso de estreñimiento. Compuesto por frangula, cáscara sagrada y fucus. ",
                "https://ld-wp73.template-help.com/woocommerce/prod_27637/v1/wp-content/uploads/2019/12/Tylenol-1.png", 4, null, null,null));
        productList.add(new Product(null, "Bekunis Complex 100 Comprimidos Gastrorresistentes", 13.00, "Tratamiento sintomático del estreñimiento ocasional o de viajero.",
                "https://ld-wp73.template-help.com/woocommerce/prod_27637/v1/wp-content/uploads/2019/12/Anacin-3.png", 4, null, null,null));
        productList.add(new Product(null, "BD Micro Fine 1ml Insulin Syringe", 42.00, "BD Micro es muy bueno para aliviar el dolor",
                "https://ld-wp73.template-help.com/woocommerce/prod_27637/v1/wp-content/uploads/2019/12/insulin-syringe-1.png", 1, null, null,null));

        productRepository.saveAll(productList);
    }
}
