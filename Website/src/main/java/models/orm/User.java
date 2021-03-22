package models.orm;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

//import jakarta.persistence.*;
import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "User.findLikeName",
                query = "select u from User u where u.userName like :name"),
        @NamedQuery(
                name = "User.findByEmailPassword",
                query = "select u from User u where u.email = :email and u.password = :password"),
})

@Data
@Entity
@jakarta.persistence.Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
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
    private List<ProductCategory> interests;

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


