package models.orm.orm;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import models.orm.ShoppingCart;

//import jakarta.persistence.*;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Data
@Entity
@jakarta.persistence.Entity
@Table(name = "dummyusers")
public class DummyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long dummyId;

    @OneToOne(optional = false)
    private ShoppingCart cart;

    @Column(nullable = false)
    private Timestamp lastActivity;

    public DummyUser() {
        this.lastActivity = new Timestamp(new Date().getTime());
    }

}


