package models.orm;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import java.sql.Date;

@NamedQueries({
        @NamedQuery(
                name = "CustomerMessage.findMessageBySubscriber",
                query = "select m from CustomerMessage m where m.subscriber = :subscriber order by m.date"),
        @NamedQuery(
                name = "CustomerMessage.findAllMessages",
                query = "select m from  CustomerMessage m order by m.date "),

})
@Data
@Entity
@Table(name = "customer_message")
public class CustomerMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String message;
    private Date date;
    String subject;
    public CustomerMessage( String message ,String subject , Date date  ){
        this.message  = message ;
        this.subject = subject;
        this.date  = date ;
    }

    @ManyToOne
    private Subscriber subscriber;
   /* public void setSubscriber(Subscriber subscriber){
        this.subscriber = subscriber;
    }*/


    public CustomerMessage() {
    }

    public CustomerMessage(Subscriber subscriber) {
        this.subscriber = subscriber;
    }


}
