/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.mapper;

import Api.dev.dto.AddressDto;
import Api.dev.entities.Address;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author alexjandrohum
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mappings({
        @Mapping(source = "addressId", target = "idAddress"),
        @Mapping(source = "insideNumber", target = "numberInside"),
        @Mapping(source = "outsideNumber", target = "numberOutside"),
        @Mapping(source = "phoneNumber", target = "numberPhone"),
        @Mapping(source = "dateCreated", target = "createdDate"),
        @Mapping(source = "dateModified", target = "modifiedDate"),
        @Mapping(source = "polityId", target = "idPolity")

    })
    Address toAddress(AddressDto addressDto);        
    List<Address> toAddresses(List<AddressDto> addressDtos);

    @InheritInverseConfiguration
    AddressDto toAddressDto(Address address);
    List<AddressDto> toAddressesDto(List<Address> address);

}
