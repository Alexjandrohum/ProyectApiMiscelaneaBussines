/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.contract;

import Api.dev.entities.Location;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alexjandrohum
 */
public interface LocationContract {
    
    List<Location> getLocations();
    
    Optional<Location> getLocationById(int idLocation);
    
}
