package models.orm.orm;

//import jakarta.persistence.*;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.sql.Date;

@NamedQueries({
        @NamedQuery(
                name = "ScratchCard.findValidCard",
                query = "select c from ScratchCard c where c.cardNumber = :cardNumber and c.valid = true"),
})

@Data
@Entity
@jakarta.persistence.Entity
@Table(name = "scratch_cards")
public class ScratchCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long cardId;

    @Column(unique = true, nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private boolean valid;

    @Column(nullable = false)
    private int value;

    public ScratchCard() {

    }


    public ScratchCard(String cardNumber, int value) {
        this.cardNumber = cardNumber;
        this.value = value;
        valid = true;
    }
}
