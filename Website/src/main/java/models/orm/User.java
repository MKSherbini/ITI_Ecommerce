package models.orm;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long userId;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String password;

    private String firstName;
    private String lastName;

    private Address address;

    private Date birthdate;

    @ManyToMany
    private List<Category> interests;

    @OneToMany(mappedBy = "owner",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ShoppingCart> carts;

    @Column(nullable = false)
    int credit;

    public User() {
    }
}
