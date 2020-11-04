package Api.dev.contract;

import Api.dev.entities.Municipality;

import java.util.List;
import java.util.Optional;

public interface MunicipalityContract {

    List<Municipality> getAll();
    
    Optional<Municipality> getMunicipalityById(int idMunicipality);

}
