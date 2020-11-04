package Api.dev.service;

import Api.dev.contract.PolityContract;
import Api.dev.dto.PolityDto;
import Api.dev.entities.Polity;
import Api.dev.mapper.PolityMapper;
import Api.dev.persistence.crud.PolityCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolityService implements PolityContract {

    @Autowired
    private PolityCrudRepository polityCrud;
    @Autowired
    private PolityMapper mapper;

    @Override
    public List<PolityDto> getAll() {
        return mapper.toPolityDtos(polityCrud.findAll());
    }
}
