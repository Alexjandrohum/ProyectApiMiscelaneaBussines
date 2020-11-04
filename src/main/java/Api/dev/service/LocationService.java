/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.service;

import Api.dev.contract.LocationContract;
import Api.dev.entities.Location;
import Api.dev.persistence.crud.LocationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexjandrohum
 */
@Service
public class LocationService implements LocationContract {

    @Autowired
    private LocationCrudRepository locationCrud;

    @Override
    public List<Location> getLocations() {
        return locationCrud.findAll();
    }

    @Override
    public Optional<Location> getLocationById(int idLocation) {
        return locationCrud.findById(idLocation);
    }

}
