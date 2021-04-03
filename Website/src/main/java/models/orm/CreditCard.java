package models.orm;

//import jakarta.persistence.*;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@NamedQueries({
        @NamedQuery(
                name = "CreditCard.findValidCard",
                query = "select c from CreditCard c where c.cardNumber = :cardNumber and c.cvv = :cvv and c.expireDate = :expireDate"),
        @NamedQuery(
                name = "CreditCard.findCardsByUser",
                query = "select c from CreditCard c where c.owner = :owner"),

})

@Data
@Entity
@Table(name = "credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long cardId;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String cvv;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    @Column(nullable = false)
    private int balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, updatable = false)
    private User owner;

    private boolean isDefault;

    public CreditCard() {

    }

    public CreditCard(String cardNumber, String cvv, Date expireDate, int balance, User owner) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expireDate = expireDate;
        this.balance = balance;
        this.owner = owner;
    }
}
