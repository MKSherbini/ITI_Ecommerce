package models.orm.orm;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import models.orm.User;

import java.sql.Date;

@NamedQueries({
        @NamedQuery(
                name = "CustomerReview.findReviewsByUser",
                query = "select r from CustomerReview r where r.owner = :user order by r.date"),
        @NamedQuery(
                name = "CustomerReview.findAllReviews",
                query = "select r from  CustomerReview r order by r.date "),

})
@Data
@Entity
@jakarta.persistence.Entity
@Table(name = "customer_review")
public class CustomerReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private int rating ;
    private String review;
    private Date date;
    public CustomerReview(int rating , String review , Date date ){
        this.rating = rating ;
        this.review = review ;
        this.date  = date ;
    }

    @ManyToOne
    private User owner;



    public CustomerReview() {
    }

    public CustomerReview(User owner) {
        this.owner = owner;
    }


}
