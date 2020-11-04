package Api.dev.mapper;

import Api.dev.dto.LocationDto;
import Api.dev.entities.Location;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mappings({
            @Mapping(source = "locationId", target = "idLocation"),
            @Mapping(source = "locationKey", target = "keyLocation"),
            @Mapping(source = "municipalityId", target = "idMunicipality"),
    })
    List<Location> toLocations(List<LocationDto> locationDtos);

    @InheritInverseConfiguration
    @Mapping(target = "municipality", ignore = true)
    List<LocationDto> toLocationDtos(List<Location> locations);
}
