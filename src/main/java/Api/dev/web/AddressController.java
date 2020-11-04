package Api.dev.web;

import Api.dev.contract.MunicipalityContract;
import Api.dev.contract.PolityContract;
import Api.dev.dto.LocationDto;
import Api.dev.dto.MunicipalityDto;
import Api.dev.dto.PolityDto;
import Api.dev.entities.Location;
import Api.dev.entities.Municipality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private MunicipalityContract municipalityContract;
    @Autowired
    private PolityContract polityContract;

    @GetMapping("/getPolities")
    public ResponseEntity<List<PolityDto>> getPolities() {
        return new ResponseEntity<>(polityContract.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getMunicipalities")
    public ResponseEntity<List<MunicipalityDto>> getMunicipalities() {
        return new ResponseEntity<>(municipalityContract.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getLocations")
    public ResponseEntity<List<LocationDto>> getLocation() {
        return new ResponseEntity<>(municipalityContract.getLocation(), HttpStatus.OK);
    }
}
