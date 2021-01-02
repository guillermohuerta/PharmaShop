package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.OrderDetails;
import pe.isil.repository.OrderDetailsRepository;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public void createOrUpdate(OrderDetails orderDetails){
        orderDetailsRepository.save(orderDetails);
    }

    public void delete(Integer id){
        orderDetailsRepository.deleteById(id);
    }

    public OrderDetails findById(Integer id){
        return orderDetailsRepository.findById(id).orElse(null);
    }

    public List<OrderDetails> findAll(){
        return orderDetailsRepository.findAll();
    }
}
