package Api.dev.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "municipality_table")
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipality")
    private Integer idMunicipality;
    @Column(name = "key_municipality")
    private String keyMunicipality;
    private String name;
    private String status;
    @Column(name = "id_polity")
    private int idPolity;
    @ManyToOne
    @JoinColumn(name = "id_polity", insertable = false, updatable = false)
    private Polity polity;
    @OneToMany(mappedBy = "municipality")
    private List<Location> locations;

    public Integer getIdMunicipality() {
        return idMunicipality;
    }

    public void setIdMunicipality(Integer idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    public String getKeyMunicipality() {
        return keyMunicipality;
    }

    public void setKeyMunicipality(String keyMunicipality) {
        this.keyMunicipality = keyMunicipality;
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

    public int getIdPolity() {
        return idPolity;
    }

    public void setIdPolity(int idPolity) {
        this.idPolity = idPolity;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
