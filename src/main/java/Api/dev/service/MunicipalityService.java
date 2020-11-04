package Api.dev.service;

import Api.dev.contract.MunicipalityContract;
import Api.dev.dto.LocationDto;
import Api.dev.dto.MunicipalityDto;
import Api.dev.entities.Location;
import Api.dev.entities.Municipality;
import Api.dev.mapper.LocationMapper;
import Api.dev.mapper.MunicipalityMapper;
import Api.dev.persistence.crud.LocationCrudRepository;
import Api.dev.persistence.crud.MunicipalityCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityService implements MunicipalityContract {

    @Autowired
    private MunicipalityCrudRepository municipalityCrud;
    @Autowired
    private MunicipalityMapper mapperMunicipality;
    @Autowired
    private LocationCrudRepository locationCrudRepository;
    @Autowired
    private LocationMapper mapperLocation;

    @Override
    public List<MunicipalityDto> getAll() {
        return mapperMunicipality.toMunicipalityDtos(municipalityCrud.findAll());
    }

    @Override
    public List<LocationDto> getLocation() {
        return mapperLocation.toLocationDtos(locationCrudRepository.findAll());
    }
}
