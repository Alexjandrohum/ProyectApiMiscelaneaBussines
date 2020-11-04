package Api.dev.contract;

import Api.dev.entities.Polity;

import java.util.List;
import java.util.Optional;

public interface PolityContract {

    List<Polity> getAll();
    
    Optional<Polity> getPolityById(int idPolity);
}
