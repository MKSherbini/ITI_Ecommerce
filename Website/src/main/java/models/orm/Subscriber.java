package models.orm;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

/*@NamedQueries({
        @NamedQuery(
                name = "CustomerReview.findReviewsByUser",
                query = "select r from CustomerReview r where r.owner = :user order by r.date")
})*/
@Data
@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(name = "fname")
    private String firstName ;
    private String email;
    private String gender ;
    private Date date;


    public Subscriber() {
    }
    public Subscriber (String firstName , String  email , Date date, String gender ){
        this . firstName = firstName ;
        this . email = email ;
        this . date = date ;
        this . gender = gender ;
    }

    @ToString.Exclude
    @OneToMany(mappedBy = "subscriber",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<CustomerReview> reviews;
    @ToString.Exclude
    @OneToMany(mappedBy = "subscriber",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<CustomerReview> messages;


}
