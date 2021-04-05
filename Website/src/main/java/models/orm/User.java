package models.orm;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

//import jakarta.persistence.*;
import javax.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "User.findLikeName",
                query = "select u from User u where u.userName like :name"),
        @NamedQuery(
                name = "User.findByEmailPassword",
                query = "select u from User u where u.email = :email and u.password = :password"),
        @NamedQuery(
                name = "User.findByEmail",
                query = "select u from User u where u.email = :email"
        ),
})

@Data
@Entity
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

    @Column(nullable = false)
    private String password;

    private String firstName;
    private String lastName;

    private Address address;

    private Date birthdate;

    @ToString.Exclude
    @ManyToMany
    private List<ProductCategory> interests = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "owner",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ShoppingCart> carts = new ArrayList<>();
    @ToString.Exclude
    @OneToMany(mappedBy = "subscriber",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<CustomerReview> reviews;

    @ToString.Exclude
    @OneToMany(mappedBy = "owner",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<CreditCard> cards = new ArrayList<>();

    @Column(nullable = false)
    double credit;

    public User() {
    }

    public User(String email, String userName, String password, String firstName, String lastName, Date birthdate, Address address) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
    }
}


