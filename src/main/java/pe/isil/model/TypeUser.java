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
public class TypeUser {

    @Id
    @Column(name = "typeUser_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    //  linking typeUser with user
    @OneToMany(mappedBy = "typeUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<User> users;
}
