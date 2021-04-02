package models.orm;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import java.sql.Date;

@NamedQueries({
        @NamedQuery(
                name = "CustomerReview.findReviewsBySubscriber",
                query = "select r from CustomerReview r where r.subscriber = :subscriber order by r.date"),
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
    private Subscriber subscriber;



    public CustomerReview() {
    }

    public CustomerReview(Subscriber subscriber) {
        this.subscriber = subscriber;
    }


}
