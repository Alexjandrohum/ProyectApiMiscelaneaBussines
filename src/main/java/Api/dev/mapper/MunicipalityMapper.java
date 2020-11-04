package Api.dev.mapper;

import Api.dev.dto.MunicipalityDto;
import Api.dev.entities.Municipality;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface MunicipalityMapper {

    @Mappings({
            @Mapping(source = "municipalityId", target = "idMunicipality"),
            @Mapping(source = "municipalityKey", target = "keyMunicipality"),
            @Mapping(source = "polityId" ,target = "idPolity"),
            @Mapping(source = "locationDtos" ,target = "locations")
    })
    List<Municipality> toMunicipalities(List<MunicipalityDto> municipalityDtos);

    @InheritInverseConfiguration
    @Mapping(target = "polityDto", ignore = true)
    List<MunicipalityDto> toMunicipalityDtos(List<Municipality> municipalities);
}
