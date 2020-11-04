package Api.dev.entities;

import javax.persistence.*;

@Entity
@Table(name = "location_table")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private Integer idLocation;
    @Column(name = "key_location")
    private String keyLocation;
    private String name;
    private String status;
    @Column(name = "id_municipality")
    private int idMunicipality;
    @ManyToOne
    @JoinColumn(name = "id_municipality", insertable = false, updatable = false)
    private Municipality municipality;

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public String getKeyLocation() {
        return keyLocation;
    }

    public void setKeyLocation(String keyLocation) {
        this.keyLocation = keyLocation;
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

    public int getIdMunicipality() {
        return idMunicipality;
    }

    public void setIdMunicipality(int idMunicipality) {
        this.idMunicipality = idMunicipality;
    }


}
