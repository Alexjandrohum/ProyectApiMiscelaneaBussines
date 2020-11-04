package Api.dev.web;

import Api.dev.contract.LocationContract;
import Api.dev.contract.MunicipalityContract;
import Api.dev.contract.PolityContract;
import Api.dev.entities.Location;
import Api.dev.entities.Municipality;
import Api.dev.entities.Polity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private MunicipalityContract municipalityContract;
    @Autowired
    private PolityContract polityContract;
    @Autowired
    private LocationContract locationContract;

    @GetMapping("/getPolities")
    public ResponseEntity<List<Polity>> getPolities() {
        return new ResponseEntity<>(polityContract.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getMunicipalities")
    public ResponseEntity<List<Municipality>> getMunicipalities() {
        return new ResponseEntity<>(municipalityContract.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getLocations")
    public ResponseEntity<List<Location>> getLocation() {
        return new ResponseEntity<>(locationContract.getLocations(), HttpStatus.OK);
    }
    
    @GetMapping("/getPolityById/{id}")
    public ResponseEntity<Polity> getPolityById(@PathVariable("id") int id){
        return polityContract.getPolityById(id)
                .map(polity -> new ResponseEntity<>(polity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/getMunicipalityById/{id}")
    public ResponseEntity<Municipality> getMunicipalityById(@PathVariable("id") int id){
        return municipalityContract.getMunicipalityById(id)
                .map(municipality -> new ResponseEntity<>(municipality, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/getLocationById/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") int id){
        return locationContract.getLocationById(id)
                .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
