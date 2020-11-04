package Api.dev.contract;

import Api.dev.dto.LocationDto;
import Api.dev.dto.MunicipalityDto;
import Api.dev.entities.Location;
import Api.dev.entities.Municipality;

import java.util.List;

public interface MunicipalityContract {

    List<MunicipalityDto> getAll();

    List<LocationDto> getLocation();
}
