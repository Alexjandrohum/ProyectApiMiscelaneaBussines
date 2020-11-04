package Api.dev.mapper;

import Api.dev.dto.PolityDto;
import Api.dev.entities.Polity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MunicipalityMapper.class})
public interface PolityMapper {

    @Mappings({
            @Mapping(source = "idPolity", target = "polityId"),
            @Mapping(source = "keyPolity", target = "polityKey"),
            @Mapping(source = "municipalities", target = "municipalitiesDto")

    })
    List<PolityDto> toPolityDtos(List<Polity> polities);

}
