/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.dto;

import Api.dev.entities.Polity;
import java.util.Date;

/**
 *
 * @author alexjandrohum
 */
public class AddressDto {

    private int addressId;
    private String street;
    private String insideNumber;
    private String outsideNumber;
    private String phoneNumber;
    private Date dateCreated;
    private Date dateModified;
    private String status;
    private int polityId;
    private Polity polity;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getInsideNumber() {
        return insideNumber;
    }

    public void setInsideNumber(String insideNumber) {
        this.insideNumber = insideNumber;
    }

    public String getOutsideNumber() {
        return outsideNumber;
    }

    public void setOutsideNumber(String outsideNumber) {
        this.outsideNumber = outsideNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPolityId() {
        return polityId;
    }

    public void setPolityId(int polityId) {
        this.polityId = polityId;
    }

    public Polity getPolity() {
        return polity;
    }

    public void setPolity(Polity polity) {
        this.polity = polity;
    }

}
