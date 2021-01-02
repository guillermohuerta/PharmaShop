package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.User;
import pe.isil.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createOrUpdate(User user){
        userRepository.save(user);
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public User findById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
