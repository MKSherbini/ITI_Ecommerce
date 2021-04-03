package models.dtos;

//import jakarta.persistence.*;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import models.orm.User;

import java.util.Date;

@Data
public class CreditCardDto {
    private Long id;
    private String cardNumberEnds;
    private Date expireDate;
    private int balance;
    private boolean defaultCard;
}
