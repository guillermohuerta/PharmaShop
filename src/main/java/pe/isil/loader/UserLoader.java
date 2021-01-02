package pe.isil.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.isil.model.User;
import pe.isil.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User(null, "Guillermo Huerta",21 ,76510306, "123", "guillermo@gmail.com", "M", "Av Arequipa 5100", 2, null, null ));
        userList.add(new User(null, "Daniel Olaya",21 ,1235489, "321", "daniel@gmail.com", "M", "Av Lince 5100", 2, null, null ));
        userList.add(new User(null, "Jafet Cánepa ",21 ,75894565, "789", "Jafet@gmail.com", "M", "Av La Molina 5100", 1, null, null ));
        userRepository.saveAll(userList);
    }
}
