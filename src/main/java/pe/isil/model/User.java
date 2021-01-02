package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private Integer dni;
    private String password;
    private String email;
    private String sex;
    private String address;

    //  linking user with typeUser
    @Column(name = "typeUser_id")
    private Integer typeUserId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeUser_id", insertable = false, updatable = false)
    private TypeUser typeUser;

    // linking user with order
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orderList;
}
