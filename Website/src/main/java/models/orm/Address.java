package models.orm;

import lombok.Data;

//import jakarta.persistence.*;
import javax.persistence.*;


@Data
@Embeddable
public class Address {
    private String streetAddress;
    private String country;
    private String city;
    private String state;
    private String zipPostalCode;

    public Address(){}

    public Address( String streetAddress , String country , String city , String state , String zipPostalCode){

    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public void setZipPostalCode(String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }
}
