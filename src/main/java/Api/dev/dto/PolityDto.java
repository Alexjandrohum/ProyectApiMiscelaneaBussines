package Api.dev.dto;

import Api.dev.entities.Address;
import Api.dev.entities.Municipality;

import java.util.List;

public class PolityDto {

    private int polityId;
    private String polityKey;
    private String name;
    private String status;
    private List<Municipality> municipalitiesDto;
    private Address address;

    public int getPolityId() {
        return polityId;
    }

    public void setPolityId(int polityId) {
        this.polityId = polityId;
    }

    public String getPolityKey() {
        return polityKey;
    }

    public void setPolityKey(String polityKey) {
        this.polityKey = polityKey;
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

    public List<Municipality> getMunicipalitiesDto() {
        return municipalitiesDto;
    }

    public void setMunicipalitiesDto(List<Municipality> municipalitiesDto) {
        this.municipalitiesDto = municipalitiesDto;
    }
}
