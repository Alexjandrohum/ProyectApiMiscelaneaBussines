package Api.dev.service;

import Api.dev.contract.MunicipalityContract;
import Api.dev.entities.Municipality;
import Api.dev.persistence.crud.MunicipalityCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipalityService implements MunicipalityContract {

    @Autowired
    private MunicipalityCrudRepository municipalityCrud;

    @Override
    public List<Municipality> getAll() {
        return municipalityCrud.findAll();
    }

    @Override
    public Optional<Municipality> getMunicipalityById(int idMunicipality) {
        return municipalityCrud.findById(idMunicipality);
    }
}
