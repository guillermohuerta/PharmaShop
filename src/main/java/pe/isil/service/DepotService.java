package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Depot;
import pe.isil.repository.DepotRepository;

import java.util.List;

@Service
public class DepotService {

    @Autowired
    private DepotRepository depotRepository;

    public void createOrUpdate(Depot depot){
        depotRepository.save(depot);
    }

    public void delete(Integer id){
        depotRepository.deleteById(id);
    }

    public Depot findById(Integer id){
        return depotRepository.findById(id).orElse(null);
    }

    public List<Depot> findAll(){
        return depotRepository.findAll();
    }
}
