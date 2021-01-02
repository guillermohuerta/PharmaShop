package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class OrderDetails {

    @Id
    @Column(name = "orderDetails_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //  linking orderDetails with order
    @Column(name = "order_id")
    private Integer orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    //  linking orderDetails with product
    @Column(name = "product_id")
    private Integer productId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    private Integer quantity;
    private Double subtotal;
}
