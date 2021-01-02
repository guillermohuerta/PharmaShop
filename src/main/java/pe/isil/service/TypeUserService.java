package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.TypeUser;
import pe.isil.repository.TypeUserRepository;

import java.util.List;

@Service
public class TypeUserService {

    @Autowired
    private TypeUserRepository typeUserRepository;

    public void createOrUpdate(TypeUser typeUser){
        typeUserRepository.save(typeUser);
    }

    public void delete(Integer id){
        typeUserRepository.deleteById(id);
    }

    public TypeUser findById(Integer id){
        return typeUserRepository.findById(id).orElse(null);
    }

    public List<TypeUser> findAll(){
        return typeUserRepository.findAll();
    }
}
