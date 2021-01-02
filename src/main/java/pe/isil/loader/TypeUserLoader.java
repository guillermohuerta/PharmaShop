package pe.isil.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.isil.model.TypeUser;
import pe.isil.repository.TypeUserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeUserLoader implements CommandLineRunner {

    @Autowired
    private TypeUserRepository typeUserRepository;

    @Override
    public void run(String... args) throws Exception {
        List<TypeUser> typeUserList = new ArrayList<>();
        typeUserList.add(new TypeUser(null, "Client",null));
        typeUserList.add(new TypeUser(null, "Employed",null));
        typeUserRepository.saveAll(typeUserList);
    }
}
