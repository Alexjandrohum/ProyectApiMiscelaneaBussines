package Api.dev.entities;

import java.io.Serializable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "polity_table")
public class Polity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_polity")
    private Integer idPolity;
    @Column(name = "key_polity")
    private String keyPolity;
    private String name;
    private String status;
    @OneToMany(mappedBy = "polity")
    private List<Municipality> municipalities;
    //@OneToOne(mappedBy = "address")
    //private Address address;

    public Integer getIdPolity() {
        return idPolity;
    }

    public void setIdPolity(Integer idPolity) {
        this.idPolity = idPolity;
    }

    public String getKeyPolity() {
        return keyPolity;
    }

    public void setKeyPolity(String keyPolity) {
        this.keyPolity = keyPolity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Municipality> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(List<Municipality> municipalities) {
        this.municipalities = municipalities;
    }
}
