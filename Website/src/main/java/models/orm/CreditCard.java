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
                query = "select c from CreditCard c where c.fakeCreditCard.cardNumber = :cardNumber and c.fakeCreditCard.cvv = :cvv and c.fakeCreditCard.expireDate = :expireDate"),
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

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(nullable = false, updatable = false)
    private FakeCreditCard fakeCreditCard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, updatable = false)
    private User owner;

    private boolean isDefault;

    public CreditCard() {

    }

    public CreditCard(FakeCreditCard fakeCreditCard, User owner) {
        this.fakeCreditCard = fakeCreditCard;
        this.owner = owner;
    }

}
