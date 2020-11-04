package Api.dev.dto;

import Api.dev.entities.Polity;

import java.util.List;

public class MunicipalityDto {

    private int municipalityId;
    private String municipalityKey;
    private String name;
    private String status;
    private int polityId;
    private PolityDto polityDto;
    private List<LocationDto> locationDtos;

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }

    public String getMunicipalityKey() {
        return municipalityKey;
    }

    public void setMunicipalityKey(String municipalityKey) {
        this.municipalityKey = municipalityKey;
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

    public int getPolityId() {
        return polityId;
    }

    public void setPolityId(int polityId) {
        this.polityId = polityId;
    }

    public List<LocationDto> getLocationDtos() {
        return locationDtos;
    }

    public void setLocationDtos(List<LocationDto> locationDtos) {
        this.locationDtos = locationDtos;
    }
}
