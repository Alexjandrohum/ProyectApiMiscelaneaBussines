package Api.dev.service;

import Api.dev.contract.PolityContract;
import Api.dev.entities.Polity;
import Api.dev.persistence.crud.PolityCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolityService implements PolityContract {

    @Autowired
    private PolityCrudRepository polityCrud;

    @Override
    public List<Polity> getAll() {

        return polityCrud.findAll();
    }

    @Override
    public Optional<Polity> getPolityById(int idPolity) {
        return polityCrud.findById(idPolity);
    }
}
