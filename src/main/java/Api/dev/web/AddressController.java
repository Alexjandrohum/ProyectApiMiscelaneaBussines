package Api.dev.web;

import Api.dev.contract.AddressContract;
import Api.dev.contract.LocationContract;
import Api.dev.contract.MunicipalityContract;
import Api.dev.contract.PolityContract;
import Api.dev.dto.AddressDto;
import Api.dev.entities.Location;
import Api.dev.entities.MessageError;
import Api.dev.entities.Municipality;
import Api.dev.entities.Polity;
import Api.dev.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private MunicipalityContract municipalityContract;
    @Autowired
    private PolityContract polityContract;
    @Autowired
    private LocationContract locationContract;
    @Autowired
    private AddressContract addressContract;

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
    public ResponseEntity<Polity> getPolityById(@PathVariable("id") int id) {
        return polityContract.getPolityById(id)
                .map(polity -> new ResponseEntity<>(polity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getMunicipalityById/{id}")
    public ResponseEntity<Municipality> getMunicipalityById(@PathVariable("id") int id) {
        return municipalityContract.getMunicipalityById(id)
                .map(municipality -> new ResponseEntity<>(municipality, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getLocationById/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") int id) {
        return locationContract.getLocationById(id)
                .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAddress")
    public ResponseEntity<List<AddressDto>> getAddress() {
        return new ResponseEntity<>(addressContract.getListAddress(), HttpStatus.OK);
    }

    @GetMapping("/getAddressById/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable("id") int id) {
        AddressDto addressDto = addressContract.getAddressById(id);
        if (addressDto != null) {
            return new ResponseEntity<>(addressDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createAddress")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto address) {
        address = addressContract.createAddress(address);
        if (address != null) {
            return new ResponseEntity(address, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<HttpStatus> updateAddress(@RequestBody AddressDto address) {
        if (addressContract.updateAddress(address) == Constant.isEnabled) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id") int id) {
        if (addressContract.deleteAddress(id) == Constant.isEnabled) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
