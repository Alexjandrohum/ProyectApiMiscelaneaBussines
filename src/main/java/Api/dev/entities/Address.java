/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
@Entity
@Table(name = "address_table")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Integer idAddress;
    private String street;
    @Column(name = "number_inside")
    private String numberInside;
    @Column(name = "number_outside")
    private String numberOutside;
    @Column(name = "number_phone")
    private String numberPhone;
    @Column(name = "created_Date")
    private Date createdDate;
    @Column(name = "modified_date")
    private Date modifiedDate;
    private String status;
    @Column(name = "id_polity")
    private int idPolity;

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberInside() {
        return numberInside;
    }

    public void setNumberInside(String numberInside) {
        this.numberInside = numberInside;
    }

    public String getNumberOutside() {
        return numberOutside;
    }

    public void setNumberOutside(String numberOutside) {
        this.numberOutside = numberOutside;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdPolity() {
        return idPolity;
    }

    public void setIdPolity(int idPolity) {
        this.idPolity = idPolity;
    }

    @Override
    public String toString() {
        return "Address{" + "idAddress=" + idAddress + ", street=" + street + ", numberInside=" + numberInside + ", numberOutside=" + numberOutside + ", numberPhone=" + numberPhone + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", status=" + status + ", idPolity=" + idPolity + '}';
    }

}
