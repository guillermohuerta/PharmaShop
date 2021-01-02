package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Order;
import pe.isil.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrUpdate(Order order){
        orderRepository.save(order);
    }

    public void delete(Integer id){
        orderRepository.deleteById(id);
    }

    public Order findById(Integer id){
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
}
