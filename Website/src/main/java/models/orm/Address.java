package models.orm;

import lombok.Data;

import javax.persistence.*;


@Data
@Embeddable
public class Address {
    private String streetAddress;
    private String country;
    private String city;
    private String state;
    private String zipPostalCode;
}
